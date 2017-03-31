<%-- 
    Document   : main
    Created on : Mar 31, 2017, 10:29:55 AM
    Author     : petter
--%>
<%@ include file="header.jsp" %>
    <%
        out.println("<h1> Welcome " + response.getHeader("username")+ "</h1>");
        out.println("Your current score is: " + response.getHeader("Score"));
        out.println("<form method='get' action='startgame'>");
        out.println("<input type='hidden' name='username' value= '"+ response.getHeader("username")+ "'/>");
        out.println("<input type='submit' value='Start game'/> </form>");

        if (response.containsHeader("status")) {
            out.println(response.getHeader("status"));
        }
     %>   
<%@ include file="footer.jsp" %>
