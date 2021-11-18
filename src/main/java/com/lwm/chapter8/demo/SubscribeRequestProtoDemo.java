package com.lwm.chapter8.demo;

import com.google.protobuf.InvalidProtocolBufferException;
import com.lwm.chapter8.protobuf.SubscribeRequestProto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : lwm
 * @Date: 2021/11/14 20:24
 * @Description: com.lwm.chapter8.demo
 * @Version: 1.0
 */
public class SubscribeRequestProtoDemo {

    private static byte[] encode(SubscribeRequestProto.SubscribeRequest request) {
        return request.toByteArray();
    }

    private static SubscribeRequestProto.SubscribeRequest decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeRequestProto.SubscribeRequest.parseFrom(body);
    }

    private static SubscribeRequestProto.SubscribeRequest createSubscribeRequest() {
        SubscribeRequestProto.SubscribeRequest.Builder builder = SubscribeRequestProto.SubscribeRequest.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("Edison");
        builder.setProductName("Netty authority guide book.");
        List<String> addresses = new ArrayList<>();
        addresses.add("Ningbo Zhejiang");
        addresses.add("Shenzhen Guangzhou");
        addresses.add("Beijing");
        builder.addAllAddress(addresses);
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeRequestProto.SubscribeRequest request = createSubscribeRequest();
        System.out.println("Before encode: " + request.toString());
        SubscribeRequestProto.SubscribeRequest aRequest = decode(encode(request));
        System.out.println("After decode: " + request.toString());
        System.out.println("Assert equals: " + request.equals(aRequest));
    }

}
