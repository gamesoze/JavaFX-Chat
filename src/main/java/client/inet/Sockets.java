package client.inet;

import client.Client;
import com.google.gson.Gson;
import server.Server;
import server.packet.Packet;
import server.packet.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sockets {
    private static Socket socket;
    private static Sockets instance;

    public Sockets() {
        try {
            socket = new Socket(Client.HOST, Server.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendPacket(Packet packet) {
        checkInstance();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(new Gson().toJson(packet));
            objectOutputStream.flush();

            System.out.println(new Gson().toJson(packet));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Packet waitPacket() {
        checkInstance();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            return new Gson().fromJson((String) objectInputStream.readObject(), Packet.class);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Response.BAD;
        }
    }

    public static void close() throws IOException {
        if (instance != null) {
            socket.close();
        }
    }

    private synchronized static void checkInstance() {
        if (instance == null) {
            instance = new Sockets();
        }
    }
}
