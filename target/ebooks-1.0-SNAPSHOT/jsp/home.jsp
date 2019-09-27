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
        <link href="../css/style-login.css" rel="stylesheet" type="text/css"/>
        <%            
          session.setAttribute("username", request.getParameter("username"));
        %>
    </head>
    <body>
        <h1>Registro</h1>
        Nombre: <%=request.getParameter("username")%>
    </body>
</html>
