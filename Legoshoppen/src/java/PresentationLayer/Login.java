/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBacces.OrderException;
import FunctionLayer.BrickCalculator;
import FunctionLayer.HouseException;
import FunctionLayer.LegoHouse;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Styklist;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
public class Login extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException{
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        if("customer".equals(user.getRole())) {
            try {
                setupForCustomer(session, user);
            } catch (HouseException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if("employee".equals(user.getRole())) {
            try {
                setUpForEmployee(session, user);
            } catch (HouseException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user.getRole() + "page";
    }
    private void setupForCustomer(HttpSession session, User user) throws OrderException, HouseException {
        
        List<Styklist> stykliste = BrickCalculator.getStyklistForUser(user);
        List<LegoHouse> orders = LogicFacade.getAllOrderForUser(user);
        session.setAttribute("stykliste", stykliste);
        session.setAttribute("orders", orders);
    }
    private void setUpForEmployee(HttpSession session, User user)throws OrderException, HouseException{
         
        List<LegoHouse> orders = LogicFacade.getAllOrders();
        
        session.setAttribute("orders", orders);
        
    }
    
}
