package com.lwm.authoritative_guide.chapter2.blocking;

import java.io.*;
import java.net.Socket;

/**
 * @author weeming
 * @date 2021/10/22 12:18
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        Socket socket = null;
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            socket = new Socket("localhost", port);
            System.out.println("Server connect success");
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println("Query Time Order");
            writer.flush();
            System.out.println("Request Send...");
            String time = null;
            if ((time = reader.readLine()) != null) {
                System.out.println(time);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
