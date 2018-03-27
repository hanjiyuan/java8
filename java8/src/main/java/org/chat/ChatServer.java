package org.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.start();
    }

    public void start() {
        while (true) {
            ServerSocket s = null;
            Socket socket = null;
            try {
                s = new ServerSocket(10001);
                socket = s.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String content = in.readLine();
                System.out.println(content);
                content = content + "1";
                out.print(content);
                out.flush(); // if not flush, client can't receive data

                in.close();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    s.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
