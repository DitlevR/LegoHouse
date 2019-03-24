/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import DBacces.OrderException;
import controller.LogicFacade;
import controller.LoginSampleException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.pkcs11.wrapper.Functions;

/**
 *
 * @author Rumle
 */
public class saveOrder extends Command{
    
    public saveOrder() {
        
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException, LoginSampleException {
        String length = request.getParameter("length");
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        int lengthI = Integer.parseInt(length);
        int widthI = Integer.parseInt(width);
        int heightI = Integer.parseInt(length);
        
        
         int user_id;
         User user;
        try {
            user_id = ((User) request.getSession().getAttribute("user")).getId();
            user = (User) request.getSession().getAttribute("user");
        } catch (NullPointerException ex) {
            throw new OrderException(ex.getMessage());
        }
        LegoHouse house = new LegoHouse(user_id, lengthI, widthI, heightI, false);
        LogicFacade.saveOrder(house);
        ArrayList<LegoHouse> orders = LogicFacade.getAllOrderForUser(user);
        request.getSession().setAttribute("orders", orders);
        return "customerpage";
        
         
       
        
        
    }
}
    

