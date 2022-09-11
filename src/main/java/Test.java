import model.User;
import org.postgresql.Driver;
import repository.WorkWithTables;
import util.PostgreSQLConnect;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        //PostgreSQLConnect.connectJDBC();
        //WorkWithTables.createTable();

        User user1 = new User(1, "Nikolaev", "Nikolay", 40);
        User user2 = new User(2, "Sidorov", "Stepan", 32);
        User user3 = new User(3, "Kravtsov", "Aleksey", 21);
        User user4 = new User(4, "Kyzmich", "Dima", 28);
        User user5 = new User(5, "Petrov", "Nikplay", 12);

        WorkWithTables workWithTables = new WorkWithTables();
        workWithTables.deleteUser(user2);
        //workWithTables.viewAllUsers();
        //workWithTables.selectUserById(user1);
        //workWithTables.updateUser();
        //workWithTables.deleteAllUsers();


    }
}
