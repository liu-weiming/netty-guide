package com.lwm.authoritative_guide.chapter5.fixed_length.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.net.InetSocketAddress;

/**
 * @Author : lwm
 * @Date: 2021/11/13 22:41
 * @Description: com.lwm.chapter5.fixed_length.client
 * @Version: 1.0
 */
public class EchoClient {

    public void connect(String host, int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                    ch.pipeline().addLast(new FixedLengthFrameDecoder(3));
                    ch.pipeline().addLast(new StringDecoder());
                    ch.pipeline().addLast(new EchoClientHandler());
                }
            });
            ChannelFuture future = bootstrap.connect(new InetSocketAddress(host, port)).sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String host = "localhost";
        int port = 8080;
        if (args != null && args.length == 2) {
            host = args[0];
            try {
                port = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Port parse error, using default port: " + port);
            }
        }
        new EchoClient().connect(host, port);
    }

}
