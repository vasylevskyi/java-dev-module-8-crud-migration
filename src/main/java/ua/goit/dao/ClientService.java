package ua.goit.dao;

import ua.goit.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createPreparedStatement;
    private PreparedStatement readPreparedStatement;
    private PreparedStatement setNamePreparedStatement;
    private PreparedStatement deleteClientByIdPreparedStatement;

    private Connection connection;
    private static String getMaxIdSql = "SELECT MAX(ID) AS id FROM CLIENT";
    private static String getAllClientsSql = "SELECT * FROM client";

    public ClientService() {}

    public ClientService(Connection connection) throws SQLException {
        createPreparedStatement = connection
                .prepareStatement("INSERT INTO client (id, name) VALUES (?, ?)");

        readPreparedStatement = connection
                .prepareStatement("SELECT id, name FROM client WHERE id = ?");

        setNamePreparedStatement = connection
                .prepareStatement("UPDATE client SET name = ? WHERE id = ?");

        deleteClientByIdPreparedStatement = connection
                .prepareStatement("DELETE from client WHERE id = ?");

        this.connection = connection;

    }


    public long create(String name) throws SQLException {
        try {
            ClientService.validateClientName(name);
        } catch (ClientNameOutOfBoundariesException e) {
            e.printStackTrace();
            return -1;
        }

        long newId = ClientService.getMaxId(connection) + 1;

        createPreparedStatement.setLong(1, newId);
        createPreparedStatement.setString(2, name);

        createPreparedStatement.executeUpdate();

        return newId;
    }


    public String getById(long id) {
        try {
            ClientService.validateClientId(id);
        } catch (NegativeClientIdException e) {
            e.printStackTrace();
            return "Change Client Id to Positive value";
        }
        try {
            readPreparedStatement.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ResultSet resultSet = readPreparedStatement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            return resultSet.getString(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void setName(long id, String name) {
        try {
            ClientService.validateClientId(id);
        } catch (NegativeClientIdException e) {
            e.printStackTrace();
            System.out.println("Change Client Id to Positive value");
        }
        try {
            setNamePreparedStatement.setString(1, name);
            setNamePreparedStatement.setLong(2, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            setNamePreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id) {
        try {
            ClientService.validateClientId(id);
        } catch (NegativeClientIdException e) {
            e.printStackTrace();
            System.out.println("Change Client Id to Positive value");
        }
        try {
            deleteClientByIdPreparedStatement.setLong(1, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            deleteClientByIdPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(getAllClientsSql);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong("id"));
                client.setName(resultSet.getString("name"));
                clients.add(client);
            }
            return clients;
        }
    }
    public static long getMaxId(Connection connection) {
        long id = 0;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getMaxIdSql);
            if (!resultSet.next()) {
                return 0;
            }
            id = resultSet.getLong("id");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public static void validateClientId(long id) throws NegativeClientIdException {
        if (id <= 0) {
            throw new NegativeClientIdException("Client Id is Negative!");
        }
    }

    public static void validateClientName(String name) throws ClientNameOutOfBoundariesException {
        if ((name.length() < 2 || name.length() > 1000)) {
            throw new ClientNameOutOfBoundariesException("Client name is out of boundaries!");
        }
    }

    public static class NegativeClientIdException extends Exception {
        public NegativeClientIdException(String message) {
            super(message);
        }
    }

    public static class ClientNameOutOfBoundariesException extends Exception {
        public ClientNameOutOfBoundariesException(String message) {
            super(message);
        }
    }
}


