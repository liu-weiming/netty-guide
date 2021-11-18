package com.lwm.chapter2.nio;

/**
 * @author weeming
 * @date 2021/10/25 19:05
 */
public class TimeServerMain {

    public static void main(String[] args) {
        new Thread(new MultiplexerTimeServer(8080)).start();
        new Thread(new TimeClientHandle("127.0.0.1", 8080)).start();
    }

}
