package server.inet;

import server.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InetConnection {
    private final ServerSocket serverSocket;
    private final ExecutorService executorService;

    public InetConnection() throws IOException {
        serverSocket = new ServerSocket(Server.PORT);
        executorService = Executors.newFixedThreadPool(Server.THREAD_COUNT);
    }

    public void start() {
        while (!serverSocket.isClosed()) {

            try {
                executorService.execute(new ChatConnection(serverSocket.accept()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
