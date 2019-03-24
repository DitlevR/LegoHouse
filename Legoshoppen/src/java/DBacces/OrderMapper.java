/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBacces;

import static FunctionLayer.LogicFacade.getAllOrderForUser;
import static FunctionLayer.LogicFacade.login;
import FunctionLayer.LoginSampleException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import FunctionLayer.LegoHouse;
import PresentationLayer.User;

/**
 *
 * @author Rumle
 */
public class OrderMapper {
    private static Connection connection = DBConnector.getConnection();
    
    public static void saveOrder(LegoHouse house) throws OrderException, LoginSampleException {
        
        try {
            String query = "INSERT INTO legoshoppen.orders (user_id, length, width, height, isShipped)"
                    + " VALUES (?,?,?,?,?);";
                    
                    
            
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, house.getUser_id());
            ps.setInt(2, house.getLength());
            ps.setInt(3, house.getWidth());
            ps.setInt(4, house.getHeight());
            ps.setBoolean(5, false);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            house.setOrder_id(id);
            
           
        } catch (SQLException e) {
             throw new OrderException(e.getLocalizedMessage());
        }
    }
    
    public static void isShipped(int id) throws OrderException {
    try {
         String query = "UPDATE Orders SET shipped = true WHERE id = ?";
         PreparedStatement ps = connection.prepareStatement(query);
         
         ps.setInt(1, id);
         ps.executeUpdate();
         
    } catch (SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }
    
    public static ArrayList<LegoHouse> getAllOrderForUser(User user) throws OrderException{
        ArrayList<LegoHouse> houses = new ArrayList<>();
        try {
            int order_id = 0;
            int user_id = 0;
            int length = 0;
            int width = 0;
            int height = 0;
            boolean isShipped = false;
            
            
        String query = "Select * from legoshoppen.orders where user_id =" + user.getId() + ";";
            
         try (
        Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery(query);
        
        while(rs.next()) {
            order_id = rs.getInt(1);
            user_id = rs.getInt(2);
            length = rs.getInt(3);
            width = rs.getInt(4);
            height = rs.getInt(5);
            isShipped = rs.getBoolean(6);
            LegoHouse house = new LegoHouse(order_id, user_id, length, height, width, isShipped);
            
            houses.add(house);
        }}
        return houses;
        
        } catch (SQLException e) {
            throw new OrderException(e.getLocalizedMessage());
        }
        
    }
    
    public static ArrayList<LegoHouse> getAllOrders() throws OrderException{
         ArrayList<LegoHouse> AllOrders = new ArrayList<>();
            int order_id = 0;
            int user_id = 0;
            int length = 0;
            int width = 0;
            int height = 0;
            boolean isShipped = false;
        String query = "select * from legoshoppen.orders;";
        
        try{
        
        try (
        Statement st = connection.createStatement()) {
                ResultSet rs = st.executeQuery(query);
        
        while(rs.next()) {
            order_id = rs.getInt(1);
            user_id = rs.getInt(2);
            length = rs.getInt(3);
            width = rs.getInt(4);
            height = rs.getInt(5);
            isShipped = rs.getBoolean(6);
            LegoHouse house = new LegoHouse(order_id, user_id, length, width, height, isShipped);
            
            AllOrders.add(house);
        }}
        return AllOrders;
        
    } catch (SQLException e) {
        throw new OrderException(e.getLocalizedMessage());
    }
        
        
        

    
    
}
 
}
