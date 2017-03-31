<%-- 
    Document   : game
    Created on : Mar 31, 2017, 11:24:54 AM
    Author     : petter
--%>
<%@ include file="header.jsp" %>
    <h3>Choose Rock, Paper, or Scissors</h3>	
    <form method="get" action="makemove">	
        ROCK <input type="radio" name="rps" value="Rock" checked><br>
        PAPER<input type="radio" name="rps" value="Paper"><br>	
        SCISSORS<input type="radio" name="rps" value="Scissors"><br>
        <% 
            out.println("<input type='hidden' name='username' value='"+ response.getHeader("username")+"'/>");
        %>

        <input type="submit" value="Submit">	
        <input type="reset" value="Reset">	
    </form>	

    <%
        out.println("<form method='get' action='main'>");
        out.println("<input type='hidden' name='username' value='"+ response.getHeader("username")+ "'/>");
        out.println("<input type='submit' value='Get Result'/> </form>");

        if(response.containsHeader("status")) {
            out.println(response.getHeader("status"));
        } 
        else if(response.containsHeader("Result")) {
            out.println("<h3> Your opponent chose " + response.getHeader("OppMove")+ "</h3>");
            out.println("<h3> You chose " + response.getHeader("Move")+ "</h3>");
            out.println("<h3>Result: " + response.getHeader("Result")+"</h3>");
            
            out.println("<form method='get' action='startgame'>");
            out.println("<input type='hidden' name='username' value='"+ response.getHeader("username")+"'/>");
            out.println("<input type='submit' value='New Game'/> </form>");



        } 
     %>	
<%@ include file="footer.jsp" %>
