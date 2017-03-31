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
            out.println("<h1> Welcome " + response.getHeader("username")+ "</h1>");
            out.println("Your current score is: " + response.getHeader("Score"));
            out.println("<form method='get' action='startgame'>");
            out.println("<input type='hidden' name='username' value= '"+ response.getHeader("username")+ "'/>");
            out.println("<input type='submit' value='Start game'/> </form>");
         %>   
    </body>
</html>
