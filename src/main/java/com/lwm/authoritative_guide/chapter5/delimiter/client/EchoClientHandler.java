package com.lwm.authoritative_guide.chapter5.delimiter.client;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author : lwm
 * @Date: 2021/11/13 21:59
 * @Description: com.lwm.chapter5.delimiter.client
 * @Version: 1.0
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private int counter = 0;
    static final String ECHO_REQ = "Hi, Newbie. Welcome to Netty.$_";

    public EchoClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("This is " + ++counter + " times receive server : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
