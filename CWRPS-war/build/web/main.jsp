<%-- 
    Document   : main
    Created on : Mar 31, 2017, 10:29:55 AM
    Author     : petter
--%>
<%@ page import="java.io.*,java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        <%
            // Set refresh, autoload time as 5 seconds
            response.setIntHeader("Refresh", 5);
            // Get current time
            out.println("<h1> Welcome " + response.getHeader("username")+ "</h1>");
            out.println("Your current score is: " + response.getHeader("score"));
         %>
    <form method="post" action="startgame">
        Click here to start a game:
        <input type="submit" name="username">
    </form>
      
    </body>
</html>
