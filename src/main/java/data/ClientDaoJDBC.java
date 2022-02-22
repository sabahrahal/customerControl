package data;

import domain.Client;
import java.sql.*;
import java.util.*;

public class ClientDaoJDBC {

    private static final String SQL_SELECT = "SELECT * FROM client";
    private static final String SQL_SELECT_BY_ID = "SELECT id, name, lastname, email, phone, balance FROM client WHERE id=?";
    private static final String SQL_INSERT = "INSERT INTO client(name, lastname, email, phone, balance) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE client SET name=?, lastname=?, email=?, phone=?, balance=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM client WHERE id = ?";

    public List<Client> list() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Client client = null;
        List<Client> clients = new ArrayList<>();
        try {
            conn = ConnectionBD.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idClient = rs.getInt("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double balance = rs.getDouble("balance");

                client = new Client(idClient, name, lastName, email, phone, balance);
                clients.add(client);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionBD.close(rs);
            ConnectionBD.close(stmt);
            ConnectionBD.close(conn);
        }
        return clients;
    }

    public Client searchById(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionBD.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, client.getIdClient());
            rs = stmt.executeQuery();
            rs.next();

            String name = rs.getString("name");
            String lastName = rs.getString("lastname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double balance = rs.getDouble("balance");

            client.setName(name);
            client.setLastName(lastName);
            client.setEmail(email);
            client.setPhone(phone);
            client.setBalance(balance);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionBD.close(rs);
            ConnectionBD.close(stmt);
            ConnectionBD.close(conn);
        }

        return client;
    }

    public int insert(Client client) {
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionBD.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhone());
            stmt.setDouble(5, client.getBalance());
            rows = stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionBD.close(stmt);
            ConnectionBD.close(conn);
        }
        return rows;
    }

    public int update(Client client) {
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionBD.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhone());
            stmt.setDouble(5, client.getBalance());
            stmt.setInt(6, client.getIdClient());
            rows = stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionBD.close(stmt);
            ConnectionBD.close(conn);
        }

        return rows;
    }

    public int delete(Client client) {
        int rows = 0;
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConnectionBD.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, client.getIdClient());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionBD.close(stmt);
            ConnectionBD.close(conn);
        }

        return rows;
    }
    
}
