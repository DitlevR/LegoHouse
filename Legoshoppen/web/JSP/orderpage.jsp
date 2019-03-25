<%-- 
    Document   : orderpage
    Created on : Mar 25, 2019, 2:59:57 PM
    Author     : Rumle
--%>

<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Styklist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order Status:</h1>
        
        <%
         List<Styklist> stykliste = (List<Styklist>) request.getSession().getAttribute("stykliste");
        for(int i = 0; i < stykliste.size(); i++) {
           out.print("<p>" + stykliste.get(i) + "</p>"); } %>
        
           <form> 
           
           <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goback">
            <input type="submit" value="back" />
           
           </form>
           
    </body>
</html>
