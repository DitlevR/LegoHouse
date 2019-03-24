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
public class Register extends Command {

    public Register() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, OrderException {
         String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            User user = LogicFacade.Register(email, password1);
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            
        
        if("employee".equals(user.getRole())) {
            try {
                setUpForEmployee(session, user);
            } catch (HouseException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user.getRole() + "page";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }
    
    private void setUpForEmployee(HttpSession session, User user)throws OrderException, HouseException{
         
        List<LegoHouse> orders = LogicFacade.getAllOrders();
        ArrayList<Styklist> stykliste = BrickCalculator.getAllStykList();
        session.setAttribute("orders", orders);
        session.setAttribute("stykliste", stykliste);
    }
    
    
    
}
