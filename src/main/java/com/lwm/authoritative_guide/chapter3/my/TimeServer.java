package com.lwm.authoritative_guide.chapter3.my;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weeming
 * @date 2021/11/6 2:46
 */
public class TimeServer {

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //use default port
            }
        }
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                        byte[] bytes = new byte[msg.readableBytes()];
                        msg.readBytes(bytes);
                        String body = new String(bytes, StandardCharsets.UTF_8);
                        System.out.println("Order received: " + body);
                        String currentTime = "QUERY TIME ORDER".equals(body) ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) : "BAD ORDER";
                        final ByteBuf byteBuf = Unpooled.copiedBuffer(currentTime.getBytes());
                        ctx.write(byteBuf);
                    }

                    @Override
                    public void channelReadComplete(ChannelHandlerContext ctx) {
                        ctx.flush();
                    }
                });
            }
        });

        final ChannelFuture future = serverBootstrap.bind(port).sync();
        future.channel().closeFuture().sync();
    }

}
