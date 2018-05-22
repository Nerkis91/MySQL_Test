package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**...*/

public class MyDbUnits {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test_kcs";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public static Connection createConnection(){
        Connection connection = null;
        try {//nurodomas kelias connectiono, log in vardas ir paswwords, siuo atveju paswordo nera
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Prisijungti nepavyko" +e);
        }
        return connection;
    }

}
