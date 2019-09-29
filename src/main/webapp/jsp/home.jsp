<%-- 
    Document   : home
    Created on : 27-sep-2019, 11:44:25
    Author     : grifiun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>        
        <%@include file="../html/css-bootstrap.html"%>
        
        <%            
          session.setAttribute("username", request.getParameter("username"));
        %>
    </head>
    <body>
        <%@include file="../html/nav.html" %>
        <h1>Registro</h1>
        Nombre: <%=request.getParameter("username")%>
        <%@include file="../html/js-bootstrap.html"%>
    </body>
</html>
