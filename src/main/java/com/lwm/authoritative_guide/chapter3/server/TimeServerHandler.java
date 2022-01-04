package com.lwm.authoritative_guide.chapter3.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weeming
 * @date 2021/11/4 19:17
 */
public class TimeServerHandler extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String body = new String(req, StandardCharsets.UTF_8);
        System.out.println("Time server received order: " + body);
        String currTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) : "BAD ORDER";
        ByteBuf resp = Unpooled.copiedBuffer(currTime.getBytes());
        ctx.write(resp);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
