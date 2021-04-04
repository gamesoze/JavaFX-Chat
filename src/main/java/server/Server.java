package server;

import server.inet.InetConnection;

import java.io.IOException;

public class Server {
    public static final int PORT = 30333;
    public static final int THREAD_COUNT = 6;

    public static void main(String[] args) {
        try {
            new InetConnection().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
