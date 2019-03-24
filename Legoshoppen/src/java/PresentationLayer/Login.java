/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import presentation.*;
import DBacces.OrderException;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.util.List;
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
            setupForCustomer(session, user);
        }
        if("employee".equals(user.getRole())) {
            setUpForEmployee(session);
        }
        return user.getRole() + "page";
    }
    private void setupForCustomer(HttpSession session, User user) throws OrderException {
        
        
        List<LegoHouse> orders = LogicFacade.getAllOrderForUser(user);
        session.setAttribute("orders", orders);
    }
    private void setUpForEmployee(HttpSession session)throws OrderException{
         
        List<LegoHouse> orders = LogicFacade.getAllOrders();
        session.setAttribute("orders", orders);
    }
    
}
