<%-- 
    Document   : home-editor
    Created on : 02-oct-2019, 14:29:22
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
            <h1>HOLA XD</h1>
            <form class="col-12 caja2" method="post" action="../../CrearRevista" > 
            <div class="modal-content align-content-start">
                <div class="form-check form-check-inline">                    
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1" name="cb1">
                    <label class="form-check-label" for="inlineCheckbox1">1</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2" name="cb1">
                    <label class="form-check-label" for="inlineCheckbox2">2</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3" name="cb1">
                    <label class="form-check-label" for="inlineCheckbox3">3 </label>
                </div>
                <button type="submit" class="btn btn-primary">obtener</button>
            </div>
            </form>
        </div>
       
    </body>
</html>
