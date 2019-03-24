<%-- 
    Document   : MakeOrder
    Created on : Mar 23, 2019, 10:12:56 PM
    Author     : Rumle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>makeorder</title>
    </head>
    
    
    <body>
           
    
        <form name="saveorder" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="saveorder">
                        length<br>
                        <input type="text" name="length" value="">
                        <br>
                        width<br>
                        <input type="text" name="width" value="">
                        <br>
                        height<br>
                        <input type="text" name="height" value="">
                        <br><br>
                        <input type="submit" value="save order">
        </form> <br>
        
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
        
        <form action="FrontController" method="post">
            <input type="hidden" name="command" value="goback">
            <input type="submit" value="back" />
    
            </form>
            
    </body>
</html>
