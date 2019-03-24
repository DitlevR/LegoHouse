<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.Styklist"%>
<%@page import="java.util.List"%>
<%@page import="PresentationLayer.LegoHouse"%>
<%@page import="FunctionLayer.LogicFacade"%>
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
        <% List<Styklist> list = (List<Styklist>) request.getSession().getAttribute("stykliste");
        for(int i = 0; i < list.size(); i++) {
            out.print("<p>" + list.get(i).toString() + "</p>");
            
        }
                %>
            
    <form action="FrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="logout" />
    
    </body>
</html>
