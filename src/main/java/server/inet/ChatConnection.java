package server.inet;

import client.inet.Sockets;
import server.packet.Packet;
import server.packet.Response;

import java.net.Socket;
import java.sql.SQLException;

public class ChatConnection implements Runnable {
    private final Socket socket;

    public ChatConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // init
        // if new -> add to BD
        // if old -> send OK and old messages
        // change control to listen client
        // after, add client as sub in publisher-subscriber pattern
    }

    // init connection and check person in DB
    private void checkPerson() {
        Packet packet = Sockets.waitPacket();

        if (packet.equals(Response.BAD)) {
            // send err
        } else {
            try {
                Sockets.sendPacket(DataBases.isPersonExist(packet));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
