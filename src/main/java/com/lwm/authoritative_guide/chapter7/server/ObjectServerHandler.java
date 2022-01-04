package com.lwm.authoritative_guide.chapter7.server;

import com.lwm.authoritative_guide.chapter7.pojo.SubscribeRequest;
import com.lwm.authoritative_guide.chapter7.pojo.SubscribeResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : lwm
 * @Date: 2021/11/14 14:51
 * @Description: com.lwm.chapter7.server
 * @Version: 1.0
 */
public class ObjectServerHandler extends ChannelInboundHandlerAdapter {

    private static ConcurrentHashMap<Integer, WeakReference<SubscribeRequest>> orders = new ConcurrentHashMap<>();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        SubscribeRequest req = (SubscribeRequest) msg;
        System.out.println("New order: " + req);
        if (orders.containsKey(req.getSubReqID())) {
            ctx.writeAndFlush(resp(req.getSubReqID(), false));
        } else {
            orders.put(req.getSubReqID(), new WeakReference<>(req));
            ctx.writeAndFlush(resp(req.getSubReqID(), true));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    private SubscribeResponse resp(int subReqID, boolean succeed) {
        SubscribeResponse resp = new SubscribeResponse();
        resp.setSubReqID(subReqID);
        if (succeed) {
            resp.setRespCode(200);
            resp.setDesc("Netty book order succeed.");
        } else {
            resp.setRespCode(400);
            resp.setDesc("order exist, do not repeat order.");
        }
        return resp;
    }
}
