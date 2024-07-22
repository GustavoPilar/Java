package db;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    // connection (session) with a specific database. SQL statements are executed and results are returned within the context of a connection.
    //https://docs.oracle.com/javase/8/docs/api/java/sql/Connection.html
    private static Connection conn = null;

    //open connection with database
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties pros = loadProperties();
                String url = pros.getProperty("dburl");

                //https://docs.oracle.com/javase/8/docs/api/java/sql/DriverManager.html
                //Attempts to establish a connection to the given database URL.
                conn = DriverManager.getConnection(url, pros);

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        //Return connection
        return conn;
    }

    //Close connection with database
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    //Method that load the properties of "db.properties"
    private static Properties loadProperties() {
        // https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            // The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. Each key and its corresponding value in the property list is a string.
            Properties props = new Properties();
            props.load(fs); //Reads a property list (key and element pairs) from the input byte stream.
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    //Close statements
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    //Close ResultSets
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
