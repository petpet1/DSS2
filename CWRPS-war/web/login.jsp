<%@ include file="header.jsp" %>
    <form method="post" action="login">
        Username : <input type="text" name="username"> ("playerA" or "playerB") <br/>
        Password : <input type="password" name="password"> (same as username) <br/>
        <input type="submit" value="Login"/>
    </form>
<%@ include file="footer.jsp" %>