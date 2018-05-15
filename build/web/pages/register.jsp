<%-- 
    Document   : register
    Created on : May 14, 2018, 11:12:01 AM
    Author     : hilmiat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Register</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/assets/css/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
      
    <form action="${pageContext.request.contextPath}/Login" method="post" class="form-signin">
      
       
        <% String msg = (String)request.getAttribute("message"); %>
        <%if(msg!=null){%>
            <div class="alert alert-danger" role="alert">
              <%=msg%>
            </div>
        <%}%>
      <h1 class="h3 mb-3 font-weight-normal">Register User</h1>
      <label for="inputEmail" class="sr-only">Email address</label>
      <input type="email" id="inputEmail" class="form-control" 
             placeholder="Email address" required autofocus name="username">
       
      <label for="fullname" class="sr-only">Fullname</label>
      <input type="text" id="fullname" class="form-control" 
             placeholder="Fullname" required name="fullname">
      
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" 
             placeholder="Password" required name="password">
  
      <label for="inputPasswordRepeat" class="sr-only">Repeat Password</label>
      <input type="password" id="inputPasswordRepeat" class="form-control" 
             placeholder="Password Repeat" required name="passwordrepeat">
      
      <input type="hidden" name="action" value="register"/>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">
          Register
      </button>
    
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>
