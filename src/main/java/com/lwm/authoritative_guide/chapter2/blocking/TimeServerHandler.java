package com.lwm.authoritative_guide.chapter2.blocking;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * @author weeming
 * @date 2021/10/21 12:16
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = null;
            String currTime = null;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println("Request order From Client: " + line);
                currTime = "QUERY TIME ORDER".equalsIgnoreCase(line) ? new Date().toString() : "BAD ORDER";
                writer.println(currTime);
                writer.flush();
            }
        } catch (IOException e) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
