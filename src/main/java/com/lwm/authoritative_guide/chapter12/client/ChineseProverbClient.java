package com.lwm.authoritative_guide.chapter12.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * @author : lwm
 * @date : 2021/12/23 22:44
 * @description : com.lwm.chapter12.client
 * @version : 1.0
 */
public class ChineseProverbClient {

    public void run(int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try   {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChineseProverbClientHandler());
            Channel channel = bootstrap.bind(0).sync().channel();
            //向网段内的所有机器广播UDP消息
            channel.writeAndFlush(
                    new DatagramPacket(
                            Unpooled.copiedBuffer("query", CharsetUtil.UTF_8),
                            new InetSocketAddress("255.255.255.255", port)))
                    .sync();
            if (!channel.closeFuture().await(15000)) {
                System.out.println("query timeout");
            }
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if (args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new ChineseProverbClient().run(port);
    }

}
