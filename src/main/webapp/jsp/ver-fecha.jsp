<%-- 
    Document   : ver-fecha
    Created on : 06-oct-2019, 1:38:29
    Author     : grifiun
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fecha</title>
        <%@include file="../html/css-bootstrap.html"%>       
        <link href="../css/style-home-editor.css" rel="stylesheet" type="text/css"/>
        <%@include file="../html/js-bootstrap.html" %>  
    </head>
    <body>
        <%@include file="../html/editor/nav-editor.html"%>        
        
        <div class="modal-content col-xl-7 text-center">
            <h3>FECHA DEL SISTEMA</h3><br></br>
            <div class="modal-content align-content-start">        
                <h3><% out.print(session.getAttribute("fecha_sistema")); %></h3>

            </div>
        </div>

            
        
    </body>
</html>
