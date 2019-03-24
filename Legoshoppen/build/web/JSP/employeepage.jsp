<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="java.util.List"%>
<%@page import="logic.LegoHouse"%>
<%@page import="controller.LogicFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        
        
        <h1>Hello <%=request.getParameter( "email")%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        
        <h1> All Orders  </h1>
        <% List<LegoHouse> list = (List<LegoHouse>) request.getSession().getAttribute("orders");
        for(int i = 0; i < list.size(); i++) {
            out.print("<p>" + "Order id: " + list.get(i).getOrder_id() +" user id: " + list.get(i).getUser_id() +" length: " + list.get(i).getLength() + " width: " +  list.get(i).getWidth()
                 + " height: " +  list.get(i).getHeight() +" shipped: " + list.get(i).isShipped() + "</p>");
            
        }
                %>
            
    <form action="FrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="logout" />
    
    </body>
</html>
