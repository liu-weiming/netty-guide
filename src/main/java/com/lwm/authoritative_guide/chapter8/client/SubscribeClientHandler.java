package com.lwm.authoritative_guide.chapter8.client;

import com.lwm.authoritative_guide.chapter8.protobuf.SubscribeRequestProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : lwm
 * @Date: 2021/11/14 21:42
 * @Description: com.lwm.chapter8.client
 * @Version: 1.0
 */
public class SubscribeClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(request(1));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("Order response: \n" + msg);
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

    private SubscribeRequestProto.SubscribeRequest request(int subReqID) {
        SubscribeRequestProto.SubscribeRequest.Builder builder = SubscribeRequestProto.SubscribeRequest.newBuilder();
        builder.setSubReqID(subReqID);
        builder.setUserName("JackRose");
        builder.setProductName("Netty authority guide.");
        List<String> addresses = new ArrayList<>();
        addresses.add("Ningbo");
        addresses.add("Shangcai");
        addresses.add("Shanghai");
        addresses.add("Beijing");
        builder.addAllAddress(addresses);
        return builder.build();
    }
}
