package nutrii.application;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Ellaira
 */
public final class DBConnect {

    public static final String USER_NAME = "Nutrii";
    public static final String PASSWORD = "Nutrii";
    private static final String URL = "jdbc:derby:Nutrii;create=true";

    Connection conn;

    public DBConnect() {
        establishConnection();
        System.out.println("hi");
       // this.update("SET CURRENT SCHEMA Nutrii");
    }

    public Connection getConnection() {
        return this.conn;
        
    }

    public void establishConnection() {
        if (this.conn == null) {
            try {
                this.conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println("Connected");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public ResultSet query(String sql) { //returns records 
        ResultSet resultSet = null;
        try {
            Connection thisConnection = this.getConnection();
            Statement statement = null;
       

            statement = thisConnection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return resultSet;
    }

    public void update(String sql) {
        Connection thisConnection = this.conn;
        Statement statement = null;

        try {
            statement = thisConnection.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
