package com.lwm.authoritative_guide.chapter7.client;

import com.lwm.authoritative_guide.chapter7.pojo.SubscribeRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : lwm
 * @Date: 2021/11/14 15:31
 * @Description: com.lwm.chapter7.client
 * @Version: 1.0
 */
public class ObjectClientHandler extends ChannelInboundHandlerAdapter {

    private static AtomicInteger orderNo = new AtomicInteger(1);

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(subReq());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Order result: " + msg);
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

    private SubscribeRequest subReq() {
        SubscribeRequest request = new SubscribeRequest();
        request.setSubReqID(orderNo.getAndIncrement());
        request.setProductName("product");
        request.setAddress("shenzhen");
        request.setPhoneNumber("17704012056");
        request.setUserName("Edison");
        return request;
    }
}
