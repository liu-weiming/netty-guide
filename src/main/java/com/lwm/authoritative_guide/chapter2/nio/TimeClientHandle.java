package com.lwm.authoritative_guide.chapter2.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author weeming
 * @date 2021/10/26 12:27
 */
public class TimeClientHandle implements Runnable {

    private String host;
    private int port;
    private static int BUFFER_SIZE = 1024;
    private boolean stop = false;
    private Selector selector;
    private SocketChannel socketChannel;

    public TimeClientHandle(String host, int port) {
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (Exception e) {
            System.out.println("Connect to server failed, system exit.");
            System.exit(-1);
        }
        while (!stop) {
            try {
                selector.select(1000);
                final Set<SelectionKey> selectedKeys = selector.selectedKeys();
                final Iterator<SelectionKey> iterator = selectedKeys.iterator();
                SelectionKey key = null;
                while (iterator.hasNext()) {
                    key = iterator.next();
                    iterator.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.exit(-1);
            }
        }
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doConnect() throws IOException {
        //如果连接成功，则注册到多路复用器上，发送请求消息，读应答
        if(socketChannel.connect(new InetSocketAddress(host, port))) {
            socketChannel.register(selector, SelectionKey.OP_READ);
            doWrite();
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            SocketChannel sc = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                if (sc.finishConnect()) {
                    sc.register(selector, SelectionKey.OP_READ);
                    doWrite();
                } else {
                    //连接失败
                    System.exit(-1);
                }
            }
            if (key.isReadable()) {
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("Now is: " + body);
                    this.stop = true;
                } else if (readBytes < 0) {
                    //对端链路关闭
                    key.cancel();
                    sc.close();
                } else {
                    //忽略
                }
            }
        }
    }

    private void doWrite() throws IOException {
        byte[] requestBytes = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(requestBytes.length);
        writeBuffer.put(requestBytes);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        if (!writeBuffer.hasRemaining()) {
            System.out.println("Request send success.");
        }
    }

}
