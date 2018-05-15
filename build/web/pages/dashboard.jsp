<%@page import="java.util.List"%>
<%@page import="entity.User"%>
<h3><%=((User)request.getAttribute("user")).getEmail()%></h3>
</div>
<div class="table-responsive">
<table class="table table-striped table-bordered" >
    <thead>
        <tr>
            <th>No</th>
            <th>Username</th>
            <th>Full Name</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <% 
            List<User> data = (List<User>)request.getAttribute("users");
            int no=0;
            for(User u:data){
                no++;
        %>
        <tr>
            <td><%=no%></td>
            <td><%=u.getEmail()%></td>
            <td><%=u.getFullname()%></td>
            <td><a href="delete?id=<%=u.getId()%>">delete</a></td>
        </tr>
        <% } %>
    </tbody>
</table>

