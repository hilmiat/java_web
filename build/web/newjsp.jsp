<%-- 
    Document   : newjsp
    Created on : May 14, 2018, 9:52:05 AM
    Author     : hilmiat
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //ini scriptlet (kode java didalam page jsp
            int i = 0;
            String nama = "Nama saya Hilmi";
         %>   
         <!-- declaration -->
         <%! int i = 1; %>
         <%! static int i2 = 2; %> 
        <h1>Hello World!</h1>
        <!--Expression-->
        Waktu pada server: <%=new Date()%>
        <h5><%=nama%></h5>
        <!-- mengakses i pada line 18 -->
        <%=(i>0)?"Positif":"Negatif"%>
        <!-- mengakses i pada line 21 -->
        <%=(this.i>0)?"Positif":"Negatif"%>
        <% out.print("Hello.."); %>
        <!-- newjsp.jsp?par=... -->
        <% String myPar = request.getParameter("par"); %>
        <%=myPar%>
        
        <%@include file="footer.jspf" %>
        <jsp:directive.include file="footer.jspf">
        </jsp:directive.include>
        
        <jsp:include page="jsp2.jsp">
            <jsp:param name="param1" value="hilmi"/>
        </jsp:include>
        
    </body>
</html>
