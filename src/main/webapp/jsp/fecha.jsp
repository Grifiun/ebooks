<%-- 
    Document   : fecha
    Created on : 06-oct-2019, 0:44:51
    Author     : grifiun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar fecha</title>
        <%@include file="../html/css-bootstrap.html"%>       
        <link href="../css/style-home-editor.css" rel="stylesheet" type="text/css"/>
        <%@include file="../html/js-bootstrap.html" %>  
    </head>
    <body>
        <%@include file="../html/editor/nav-editor.html"%>
        
        
        <div class="modal-content col-xl-7 text-center">
            <h3>FECHA DEL SISTEMA</h3><br></br>
            <h4>ebooks code'n bugs</h4>
            <div class="modal-content align-content-start">        
                <form class="col-12 caja2" method="post" action="../../ControladorFecha">             
                    <div class="form-group align-self-start">
                        <h5>Nombre de la revista</h5>
                        <input type="date" class="form-control" required name="fecha"/>
                    </div>                
                    <button type="submit" class="btn btn-dark">Guardar cambios</button>
               </form>
            </div>
        </div>

            
        
    </body>
</html>
