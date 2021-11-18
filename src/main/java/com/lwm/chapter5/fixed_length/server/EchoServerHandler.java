package com.lwm.chapter5.fixed_length.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author : lwm
 * @Date: 2021/11/13 22:40
 * @Description: com.lwm.chapter5.fixed_length.server
 * @Version: 1.0
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Received client: [" + msg + "]");
        ctx.writeAndFlush(Unpooled.copiedBuffer("OK!\n".getBytes()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
