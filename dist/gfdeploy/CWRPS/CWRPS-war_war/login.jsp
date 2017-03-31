<!DOCTYPE html>
<%@page import="java.util.*" %>

<html>
    <head>
        <title>Log-In</title>
        <meta http-equiv=Content-Type content="text/html">
    </head>

    <body>

    <form method="post" action="login">

    <table width="100%">
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
        <td><input type="submit"/></td>
    </table>
    </form>
    </body>
</html>