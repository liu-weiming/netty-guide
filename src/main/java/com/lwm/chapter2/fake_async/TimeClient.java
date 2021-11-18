package com.lwm.chapter2.fake_async;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author weeming
 * @date 2021/10/23 20:13
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Send request to server...");
            writer.println("QUERY TIME ORDER");
            String response = reader.readLine();
            System.out.println("Server response: \n" + response);
        } catch (IOException e) {
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

}
