<%-- 
    Document   : publicar-revistas
    Created on : 03-oct-2019, 2:21:40
    Author     : grifiun
--%>

<%@page import="conection.RegistroCategoria"%>
<%@page import="conection.EnlaceJDBC"%>
<%@page import="entidades.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ArrayList<Categoria> categoriasAux = new ArrayList();
    categoriasAux = RegistroCategoria.obtenerTodasLasCategorias(EnlaceJDBC.EnlaceJDBC());
    
    pageContext.setAttribute("categorias", categoriasAux);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicar Revistas</title>
        <%@include file="../html/css-bootstrap.html"%>
        <link href="../css/style-home-editor.css" rel="stylesheet" type="text/css"/>
        <%@include file="../html/js-bootstrap.html" %>       
        
        
    </head>
    <body> 
       
        <%@include file="../html/editor/nav-editor.html"%>
        <%@include file="../html/editor/parte-superior-nueva-revista.html"%>
        <%@include file="../html/editor/radioButtons.html"%>
        <%@include file="../html/editor/parte-inferior-nueva-revista.html"%>
        <%@include file="../html/js-bootstrap.html" %>              
        
        
    </body>
</html>