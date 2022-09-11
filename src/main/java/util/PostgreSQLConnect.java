package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
public class PostgreSQLConnect {
    private static  String url = "jdbc:postgresql://localhost:5432/MB";
    private static  String username = "postgres";
    private static  String password = "erutus91";
    private static  Logger logger = Logger.getLogger("util.PostgreSQLConnect");

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        PostgreSQLConnect.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        PostgreSQLConnect.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        PostgreSQLConnect.password = password;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        PostgreSQLConnect.logger = logger;
    }

    public static void connectJDBC() {
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            if (null != connection) {
                logger.info("------ Пoдkлючeниe ycтaнoвлeнo ------");
            } else {
                logger.info("------ Пoдkлючeниe НE ycтaнoвлeнo ------");
            }
        }
        catch(SQLException es){
            logger.info(es.getSQLState() + es.getMessage());
            es.printStackTrace();
        }
    }
}
