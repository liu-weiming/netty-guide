package com.lwm.authoritative_guide.chapter3.my;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author weeming
 * @date 2021/11/6 16:17
 */
public class TimeClient {

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                        byte[] bytes = new byte[msg.readableBytes()];
                        msg.readBytes(bytes);
                        String resp = new String(bytes, "UTF-8");
                        System.out.println("Now is: " + resp);
                    }

                    @Override
                    public void channelActive(ChannelHandlerContext ctx) {
                        byte[] bytes = "QUERY TIME ORDER".getBytes();
                        final ByteBuf writeBuf = Unpooled.buffer(bytes.length);
                        writeBuf.writeBytes(bytes);
                        ctx.writeAndFlush(writeBuf);
                    }

                    @Override
                    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                        ctx.close();
                    }

                    @Override
                    public void channelReadComplete(ChannelHandlerContext ctx) {
                        ctx.close();
                    }
                });
            }
        });

        final ChannelFuture future = bootstrap.connect("127.0.0.1", port).sync();
        future.channel().closeFuture().sync();
    }

}
