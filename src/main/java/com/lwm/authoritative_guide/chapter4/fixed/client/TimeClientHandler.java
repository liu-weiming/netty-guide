package com.lwm.authoritative_guide.chapter4.fixed.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author weeming
 * @date 2021/11/7 4:29
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        byte[] bytes = ("QUERY TIME ORDER" + System.getProperty("line.separator")).getBytes();
        ByteBuf writeBuf = Unpooled.buffer(bytes.length);
        writeBuf.writeBytes(bytes);
        ctx.writeAndFlush(writeBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String resp = (String) msg;
        System.out.println("Now is: " + resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.close();
    }
}
