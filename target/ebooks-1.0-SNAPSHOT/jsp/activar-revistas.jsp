<%-- 
    Document   : activar-revistas
    Created on : 06-oct-2019, 8:49:52
    Author     : grifiun
--%>

<%@page import="conection.EnlaceJDBC"%>
<%@page import="conection.RegistroRevista"%>
<%@page import="entidades.EdicionRevista"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    ArrayList<EdicionRevista> conjuntoEdicionRevista = new ArrayList();
    conjuntoEdicionRevista = RegistroRevista.obtenerRevistas(EnlaceJDBC.EnlaceJDBC(), "0");    
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
        <div class="container" width="70%">
            
            <%
                for(int i = 0; i < conjuntoEdicionRevista.size(); i++){
            %>            
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Revista: <%=conjuntoEdicionRevista.get(i).getNombreRevista()%>
                    </a>
                    <div>
                        <form class="col-12 caja2" method="post" action="../../ControladorAutorizarRevistas?id=<%=conjuntoEdicionRevista.get(i).getIdEdicionRevista()%>" > 
                            <div class="form-group">
                                <h5>Titulo de la edicion de la revista:</h5> <h6><%=conjuntoEdicionRevista.get(i).getTituloEdicionRevista()%></h6>
                            </div>
                            <div class="form-group">
                                <h5>Autor:</h5><h6"> <%=conjuntoEdicionRevista.get(i).getUsernameEditor()%></h6>
                            </div>
                            <div class="form-group">
                                <h5>Costo de suscripcion a la revista entera (no es por edicion): </h5><h6><%=conjuntoEdicionRevista.get(i).getCostoSuscripcion()%></h6>
                            </div>
                            <div class="form-group">
                                <h5>Descripcion de la revista</h5><h6>"><%=conjuntoEdicionRevista.get(i).getDescripcionEdicionRevista()%></h6>
                            </div>
                            <div class="form-group">
                                <h5>Fecha de creacion: </h5><h6><%=conjuntoEdicionRevista.get(i).getFechaPublicacionEdicionRevista()%></h6>
                            </div>
                            <button type="submit" class="btn btn-primary">Autorizar</button>
                        </form> 
                    </div>
                 </li> 
            <%       
                }        
            %>
                      
        </div>
    </body>
</html>
