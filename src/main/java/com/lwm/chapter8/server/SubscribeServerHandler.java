package com.lwm.chapter8.server;

import com.lwm.chapter8.protobuf.SubscribeRequestProto;
import com.lwm.chapter8.protobuf.SubscribeResponseProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author : lwm
 * @Date: 2021/11/14 21:14
 * @Description: com.lwm.chapter8.server
 * @Version: 1.0
 */
public class SubscribeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        SubscribeRequestProto.SubscribeRequest request = (SubscribeRequestProto.SubscribeRequest) msg;
        System.out.println("Request received: \n" + request);
        ctx.writeAndFlush(resp(request.getSubReqID()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    private SubscribeResponseProto.SubscribeResponse resp(int subReqID) {
        SubscribeResponseProto.SubscribeResponse.Builder builder = SubscribeResponseProto.SubscribeResponse.newBuilder();
        builder.setSubReqID(subReqID);
        builder.setRespCode(200);
        builder.setDesc("Netty authority guide book ordered.");
        return builder.build();
    }
}
