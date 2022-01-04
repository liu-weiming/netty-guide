package com.lwm.authoritative_guide.chapter2.aio.client.my;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * @author weeming
 * @date 2021/11/4 12:15
 */
public class AsyncTimeClientHandler implements Runnable {

    private String host;
    private int port;
    private CountDownLatch latch;
    private AsynchronousSocketChannel client;

    public AsyncTimeClientHandler(String host, int port) throws IOException {
        this.host = host;
        this.port = port;

        client = AsynchronousSocketChannel.open();
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        client.connect(new InetSocketAddress(host, port), null, new CompletionHandler<Void, Object>() {
            @Override
            public void completed(Void result, Object attachment) {
                byte[] bytes = "QUERY TIME ORDER".getBytes();
                ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
                writeBuffer.put(bytes);
                writeBuffer.flip();
                client.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        if (attachment.hasRemaining()) {
                            client.write(attachment, attachment, this);
                        } else {
                            //读取服务端响应
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                                @Override
                                public void completed(Integer result, ByteBuffer attachment) {
                                    attachment.flip();
                                    byte[] bytes = new byte[attachment.remaining()];
                                    attachment.get(bytes);
                                    if (bytes.length > 0) {
                                        String response = new String(bytes, StandardCharsets.UTF_8);
                                        System.out.println("Now is: " + response);
                                        latch.countDown();
                                    }
                                }

                                @Override
                                public void failed(Throwable exc, ByteBuffer attachment) {
                                    exc.printStackTrace();
                                    latch.countDown();
                                }
                            });
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        exc.printStackTrace();
                        latch.countDown();
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
