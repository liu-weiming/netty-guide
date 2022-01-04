package com.lwm.authoritative_guide.chapter2.fake_async;

import com.lwm.authoritative_guide.chapter2.blocking.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weeming
 * @date 2021/10/23 17:25
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        TimeServerHandlerPool executor = new TimeServerHandlerPool(16, 100);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                final Socket socket = serverSocket.accept();
                executor.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

}
