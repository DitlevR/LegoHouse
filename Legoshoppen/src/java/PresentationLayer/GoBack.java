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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rumle
 */
public class GoBack extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws OrderException, LoginSampleException, HouseException {
        HttpSession session = request.getSession();
        
        User user = (User) request.getSession().getAttribute("user");
        List<Styklist> stykliste = BrickCalculator.getStyklistForUser(user);
        List<LegoHouse> orders = LogicFacade.getAllOrderForUser(user);
        session.setAttribute("stykliste", stykliste);
        session.setAttribute("orders", orders);
        return "customerpage";
    }
    
}
