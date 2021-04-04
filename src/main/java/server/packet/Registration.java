package server.packet;

public class Registration implements Packet {
    public String login;
    public String password;

    public Registration(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
