package com.lwm.chapter2.aio.client;

/**
 * @author weeming
 * @date 2021/11/3 23:12
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //using default port
            }
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-TimeClient").start();
    }

}
