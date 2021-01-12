package server.packet;

public class Registration implements Packet {
    public String name;
    public String password;

    public Registration(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
