package com.lwm.chapter2.aio.client.my;

import java.io.IOException;

/**
 * @author weeming
 * @date 2021/11/4 12:13
 */
public class TimeClient {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8080;
        new Thread(new AsyncTimeClientHandler(host, port), "AIO-TimeClient").start();
    }

}
