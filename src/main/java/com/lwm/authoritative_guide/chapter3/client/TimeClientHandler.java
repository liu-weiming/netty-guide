package com.lwm.authoritative_guide.chapter3.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author weeming
 * @date 2021/11/6 16:46
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private final ByteBuf firstMessage;

    public TimeClientHandler() {
        byte[] bytes = "QUERY TIME ORDER".getBytes();
        firstMessage = Unpooled.buffer(bytes.length);
        firstMessage.writeBytes(bytes);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] bytes = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bytes);
        String currTime = new String(bytes, "UTF-8");
        System.out.println("Now is: " + currTime);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
