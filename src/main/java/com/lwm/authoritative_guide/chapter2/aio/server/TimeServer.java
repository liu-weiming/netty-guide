package com.lwm.authoritative_guide.chapter2.aio.server;

/**
 * @author weeming
 * @date 2021/11/1 19:27
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (Exception e) {
                //using default port 8080
                System.out.println("port parsing failed, using default port 8080");
            }
        }
        new Thread(new AsyncTimeServerHandler(port), "AIO-timeserver").start();
    }

}
