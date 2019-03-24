/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBacces.OrderException;
import DBacces.OrderMapper;
import DBacces.UserMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import FunctionLayer.LegoHouse;
import PresentationLayer.User;

/**
 *
 * @author Rumle
 */
public class LogicFacade {

    public static User Register(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.Register(user);
        return user;
    }

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static void saveOrder(LegoHouse house) throws OrderException, LoginSampleException{
        OrderMapper.saveOrder(house);
    }

    public static void isShipped(int id) throws OrderException {
        OrderMapper.isShipped(id);
    }
    public static ArrayList<LegoHouse> getAllOrderForUser(User user) throws OrderException{
        return OrderMapper.getAllOrderForUser(user);
    }
    
    
    public static ArrayList<LegoHouse> getAllOrders() throws OrderException{
        return OrderMapper.getAllOrders();
    }
    
    
        
    
    public static void main(String[] args) throws OrderException, LoginSampleException, HouseException{
        User user = login("someone@nowhere.com", "sesam");
        LegoHouse house = new LegoHouse(0 ,user.getId(), 12, 53, 10, false);
        
        
        
        
       
    }
}
