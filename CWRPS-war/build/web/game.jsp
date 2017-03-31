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
        <h3>Choose Rock, Paper, or Scissors</p>	
        <form method="get" action="makemove">	
            ROCK <input type="radio" name="rps" value="Rock" checked><br>
            PAPER<input type="radio" name="rps" value="Paper"><br>	
            SCISSORS<input type="radio" name="rps" value="Scissors"><br>
            <% 
                out.println("<input type='text' name='username' value='"+ response.getHeader("username")+"'/>");
            %>
           
            <input type="submit" value="Submit">	
            <input type="reset" value="Reset">	
        </form>	
        
        <%
            //response.setIntHeader("Refresh", 5);
            out.println("<h1> Welcome " + response.getHeader("username")+ "</h1>");
            out.println("<form method='get' action='main'>");
            out.println("<input type='hidden' name='username' value='"+ response.getHeader("username")+ "'/>");
            out.println("<input type='submit' value='Get opponent move'/> </form>");
                   
            if(response.containsHeader("Result")) {
                out.println("<h1> Your opponent chose " + response.getHeader("OppMove")+ "</h1>");
                out.println("<h1> You chose " + response.getHeader("Move")+ "</h1>");
                out.println("Result: " + response.getHeader("Result"));
            }
         %>
       
    </body>
</html>
