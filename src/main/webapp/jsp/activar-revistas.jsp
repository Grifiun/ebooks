<%-- 
    Document   : activar-revistas
    Created on : 06-oct-2019, 8:49:52
    Author     : grifiun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    ArrayList<Categoria> categoriasAux = new ArrayList();
    categoriasAux = RegistroCategoria.obtenerTodasLasCategorias(EnlaceJDBC.EnlaceJDBC());
    
    pageContext.setAttribute("categorias", categoriasAux);
%>

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
        
    </body>
</html>
