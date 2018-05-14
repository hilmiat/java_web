<%-- 
    Document   : login
    Created on : May 14, 2018, 11:12:01 AM
    Author     : hilmiat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <% String msg = (String)request.getAttribute("message"); %>
        <%=(msg!=null)?msg:""%>
        <h1>Login</h1>
        <form method="post">
            Username:<input type="text" name="username"/>
            Password:<input type="password" name="password"/>
            <input type="submit" name="action" value="Login"/>
        </form>
    </body>
</html>
