<%@page import="entity.User"%>
<h3><%=((User)request.getAttribute("user")).getEmail()%></h3>