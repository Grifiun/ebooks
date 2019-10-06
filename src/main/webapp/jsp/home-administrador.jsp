<%-- 
    Document   : home-administrador
    Created on : 06-oct-2019, 8:29:24
    Author     : grifiun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@include file="../html/css-bootstrap.html"%>       
        <link href="../css/style-home-editor.css" rel="stylesheet" type="text/css"/>
        <%@include file="../html/js-bootstrap.html" %>  
           
    </head>
    <body>
        <%@include file="../html/editor/nav-editor.html"%>
        <%
            out.print(session.getAttribute("username"));
        %>
        <div class="modal-content col-xl-7 text-center">
            
            
        </div>       
    </body>
</html>
