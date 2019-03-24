/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBacces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {

    private static Connection connection = null;

    //Constants
    private static final String IP = "167.99.209.155";
    private static final String PORT = "3306";
    public static final String DATABASE = "legoshoppen";
    private static final String USERNAME = "legomaster";
    private static final String PASSWORD = "Legomaster#1";
    private static String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
    
    /**
     * constructor for DBConnector, creates a connection to use in the rest of the program
     * 
     * @throws Exception 
     */
    public DBConnector() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();        

        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }
    
    /**
     * creates and returns a connection 
     * 
     * @return Connection
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                              
                connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException | 
                    InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}
