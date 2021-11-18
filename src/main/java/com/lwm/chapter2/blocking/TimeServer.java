package com.lwm.chapter2.blocking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weeming
 * @date 2021/10/21 12:12
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server start up, listening...");
            Socket socket = null;
            while(true) {
                socket = server.accept();
                System.out.println("New socket accept.");
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
