/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsm;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Maaz
 */
public class Query {

    private Statement stmt = null;
    private static Connection conn;
    private boolean bool = false;
    ResultSet rs = null;

    public Query() {
    }

    private void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/imsi_dump";
            String user = "root";
            String pwd = "skm2010";
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal...");
        }
    }

    public boolean insertImsi(String imsi) {
        try {
            connect();
            stmt = conn.createStatement();
            String sql = "INSERT INTO addimsi(imsi) values('" + imsi + "')";
            bool = stmt.execute(sql);
        } catch (SQLException ex) {
            System.out.println("SQLExceptio : " + ex.getMessage());
        }
        return bool;
    }
    
    public boolean updateProgress() {
        try {
            connect();
            stmt = conn.createStatement();
            String sql = "UPDATE player SET progress='0'";
            bool = stmt.execute(sql);
        } catch (SQLException ex) {
            System.out.println("SQLExceptio : " + ex.getMessage());
        }
        return bool;
    }

    public boolean deleteImsi(String table) {
        try {
            connect();
            stmt = conn.createStatement();
            String sql = "DELETE FROM " + table;
            bool = stmt.execute(sql);
        } catch (SQLException ex) {
            System.out.println("SQLExceptio : " + ex.getMessage());
        }
        return bool;
    }

    public ResultSet selectImsi() throws SQLException {
        connect();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * from v_imsi ORDER BY date DESC";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("SQLException : " + e.getMessage());
        }

        return rs;
    }

    public ResultSet selectAddImsi() throws SQLException {
        connect();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * from addimsi ORDER BY id DESC";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("SQLExceptio : " + e.getMessage());
        }

        return rs;
    }

    public ResultSet selectDataSama(String imsi) throws SQLException {
        connect();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * from addimsi WHERE imsi='" + imsi + "'";
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("SQLExceptio : " + e.getMessage());
        }

        return rs;
    }

    public ResultSet selectTable(String table) throws SQLException {
        connect();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * from " + table;
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("SQLExceptio : " + e.getMessage());
        }

        return rs;
    }
}
