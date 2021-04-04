package server.inet;

import server.packet.Packet;
import server.packet.Registration;

import java.security.MessageDigest;
import java.sql.*;

public class DataBases {

    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public static final String CON_STRING = "jdbc:mysql://localhost:3306/?" +
            "user=root&" +
            "password=root&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC";
    private static Connection connection;

    static {
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(CON_STRING);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL driver not found!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static Packet isPersonExist(Packet packet) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        ResultSet tables =
                databaseMetaData.getTables(null, null, ((Registration) packet).login, null);

        if (tables.next()) {
            // table exist
            return isPasswordRight(packet, tables);
        } else {
            // not exist
            MessageDigest.getInstance("SHA-512");
        }
    }

    private static Packet isPasswordRight(Packet packet, ResultSet tables) {
        if (((Registration) packet).password.equals(tables.getString("")))
    }
}
