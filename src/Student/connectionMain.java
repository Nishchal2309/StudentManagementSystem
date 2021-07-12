package Student;
import java.sql.*;

// this class creates connection with mySQL database
public class connectionMain {

    public Connection con; // interface Connection, SQL statements are executed and results are returned withing the co thhe context of connection
    public Statement queries;// Statement interface provides you methods to execture queries against a relatrioanl database

    public connectionMain(){
        String url;
        try {
            // registering drivers
            // make sure eto add mysql library to external libraries
            url = "jdbc:mysql:///courseNames?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");// set connection
            queries= con.createStatement(); // statement object for sending SQL queries
        }catch (Exception ex){

        }

    }


}
