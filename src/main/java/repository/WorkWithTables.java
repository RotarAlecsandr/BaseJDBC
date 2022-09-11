package repository;

import model.User;
import util.PostgreSQLConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class WorkWithTables {
    private static Logger logger = Logger.getLogger("util.WorkWithTables");

    public static void createTable(){
        try (Connection connection = DriverManager.getConnection(PostgreSQLConnect.getUrl(), PostgreSQLConnect.getUsername(), PostgreSQLConnect.getPassword())) {
            PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE users" +
                    "(id SERIAL PRIMARY KEY ,\n" +
                    "first_name  VARCHAR NOT NULL ,\n" +
                    "last_name VARCHAR NOT NULL ,\n" +
                    "age integer NOT NULL) ");
            preparedStatement.executeUpdate();
            logger.info("Таблица созданна.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTable(User user){
        try (Connection connection = DriverManager.getConnection(PostgreSQLConnect.getUrl(), PostgreSQLConnect.getUsername(), PostgreSQLConnect.getPassword())) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (id, first_name, last_name, age) VALUES (?, ?, ?, ?);");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.executeUpdate();
            logger.info("Пользователь " + user + " внесен в базу данных.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(PostgreSQLConnect.getUrl(), PostgreSQLConnect.getUsername(), PostgreSQLConnect.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();
            logger.info("Пользователь " + user + " удален из базы данных");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  void viewAllUsers(){
        try {
            Connection connection = DriverManager.getConnection(PostgreSQLConnect.getUrl(), PostgreSQLConnect.getUsername(), PostgreSQLConnect.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String first = resultSet.getString("first_name");
                String last = resultSet.getString("last_name");

                System.out.print("id: " + id);
                System.out.print(", firstName: " + first);
                System.out.print(", lastName: " + last);
                System.out.println(", age: " + age);
            }
            logger.info("Показанны все пользователи базы данных.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void selectUserById(User user){
        try{
            Connection connection = DriverManager.getConnection(PostgreSQLConnect.getUrl(), PostgreSQLConnect.getUsername(), PostgreSQLConnect.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String first = resultSet.getString("first_name");
                String last = resultSet.getString("last_name");

                System.out.print("id: " + id);
                System.out.print(", firstName: " + first);
                System.out.print(", lastName: " + last);
                System.out.println(", age: " + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateUser(){

        try{
            Connection connection = DriverManager.getConnection(PostgreSQLConnect.getUrl(), PostgreSQLConnect.getUsername(), PostgreSQLConnect.getPassword());
            String updateUsers = "UPDATE users SET age =  30  where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateUsers);
            preparedStatement.setInt(1, 1);
            int count = preparedStatement.executeUpdate();
            System.out.println("Внесено " + count + " изменений в табллицу данных");
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public void deleteAllUsers(){
        try {
             Connection connection = DriverManager.getConnection(PostgreSQLConnect.getUrl(), PostgreSQLConnect.getUsername(), PostgreSQLConnect.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users");
             int count = preparedStatement.executeUpdate();
             System.out.println("Удалена " + count + " строки из табллицы данных");
             preparedStatement.close();
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }
    }
}
