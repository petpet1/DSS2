<%-- 
    Document   : game
    Created on : Mar 31, 2017, 11:24:54 AM
    Author     : petter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game page</title>
    </head>
    <body>
        <%
            if(response.containsHeader("Result")) {
                out.println("<h1> Your opponent chose " + response.getHeader("OppMove")+ "</h1>");
                out.println("<h1> You chose " + response.getHeader("Move")+ "</h1>");
                out.println("Result: " + response.getHeader("Result"));
            }
         %>
        
        <h3>Choose Rock, Paper, or Scissors</p>	
        <form method="get" action="makemove">	
            ROCK <input type="radio" name="rps" value="Rock" checked><br>
            PAPER<input type="radio" name="rps" value="Paper"><br>	
            SCISSORS<input type="radio" name="rps" value="Scissors"><br>
            <input type="submit" value="Submit">	
            <input type="reset" value="Reset">	
        </form>	
    </body>
</html>
