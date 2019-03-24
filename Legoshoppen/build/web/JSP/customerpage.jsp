<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="FunctionLayer.Styklist"%>
<%@page import="PresentationLayer.LegoHouse"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="PresentationLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        
    <link rel="stylesheet" type="text/css" href="css.css">
</head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
         <% User user = (User) request.getSession().getAttribute("user");
        out.print("<h1> Hello! " + user.getEmail() + "</h1>");
        
            %> 
        You are now logged in as a customer of our wonderful site.
        <h1>All your orders:</h1>
         <% List<LegoHouse> list = (List<LegoHouse>) request.getSession().getAttribute("orders");
         List<Styklist> stykliste = (List<Styklist>) request.getSession().getAttribute("stykliste");
        for(int i = 0; i < list.size(); i++) {
           
            
            
            out.print("<p>" + "Order id: " + list.get(i).getOrder_id() +" user id: " + list.get(i).getUser_id() +" length: " + list.get(i).getLength() + " width: " +  list.get(i).getWidth()
                 + " height: " +  list.get(i).getHeight() +" shipped: " + list.get(i).isShipped() + "</p>");
            out.print(stykliste.get(i) + "<br>");
        }
                %> 
        
    
            <form>
    <button name="command" value="makeorder">make new order</button>
    
    <form action="FrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="logout" />
    
            </form>
        </body>
</html>
