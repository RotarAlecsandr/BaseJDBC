import model.AddressUser;
import model.User;
import repository.WorkWithTables;

public class Test {
    public static void main(String[] args) {
        //PostgreSQLConnect.connectJDBC();
        //WorkWithTables.createTable();

        User user1 = new User("Nikolaev", "Nikolay", 40);
        User user2 = new User("Sidorov", "Stepan", 32);
        User user3 = new User("Kravtsov", "Aleksey", 21);
        User user4 = new User("Kyzmich", "Dima", 28);
        User user5 = new User("Petrov", "Nikplay", 12);

        AddressUser addressUser1 = new AddressUser(1, "Minsk", "Lenina", 30);
        AddressUser addressUser2 = new AddressUser(2, "Brest", "Gorkogo", 20);
        AddressUser addressUser3 = new AddressUser(3, "Moscow", "Kruzo", 37);
        AddressUser addressUser4 = new AddressUser(4, "London", "Sports", 34);
        AddressUser addressUser5 = new AddressUser(5, "Minsk", "Lenina", 30);

        WorkWithTables workWithTables = new WorkWithTables();

        //workWithTables.addTable(user1);
        //workWithTables.addTable(user2);
        //workWithTables.addTable(user3);
        //workWithTables.addTable(user4);
        //workWithTables.addTable(user5);

        //workWithTables.addTableAddress(addressUser1);
        //workWithTables.addTableAddress(addressUser2);
        //workWithTables.addTableAddress(addressUser3);
        //workWithTables.addTableAddress(addressUser4);
        //workWithTables.addTableAddress(addressUser5);
    }
}
