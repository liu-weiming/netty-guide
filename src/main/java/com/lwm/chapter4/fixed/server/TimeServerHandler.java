package com.lwm.chapter4.fixed.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weeming
 * @date 2021/11/7 5:01
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String req = (String) msg;
        System.out.println("New order received: " + req);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) : "BAD ORDER";
        currentTime += System.getProperty("line.separator");
        ByteBuf writeBuf = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(writeBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("Exception caught: " + cause.getCause());
        ctx.close();
    }
}
