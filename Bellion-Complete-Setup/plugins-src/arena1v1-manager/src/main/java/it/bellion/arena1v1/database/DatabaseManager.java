package it.bellion.arena1v1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;
    private final String url, user, password;

    public DatabaseManager(String host, int port, String db, String user, String password) {
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false&autoReconnect=true";
        this.user = user;
        this.password = password;
    }

    public boolean connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isConnected() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public ResultSet query(String sql, Object... params) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeQuery();
    }

    public int update(String sql, Object... params) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        return ps.executeUpdate();
    }
}