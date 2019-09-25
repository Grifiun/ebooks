<%-- 
    Document   : index
    Created on : 25-sep-2019, 0:56:36
    Author     : grifiun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./style-login.css">
    </head>
    <body>
        <header>
            <h1>eBook's Code'n Bugs</h1>            
        </header>
        <div>
            <article>
                <h3>username:</h3>
            </article>
            <article>
                <input type="text" id="username"/>
            </article>
            <article>
                <h3>contraseña:</h3>
            </article>
            <article>
                <input type="text" id="pass1"/>
            </article>
            <article>
                <h3>Repita la contraseña:</h3>
            </article>
            <article>
                <input type="text" id="pass2"/>
            </article>
            <article>                
                <button onclick="iniciarSesion()" type="button">Iniciar Sesion</button>
            </article>            
        </div>
        <footer>
            <p class="pFooter">Introducción a la programación 2 - IPC2</p>
            <p class="pFooter">Derechos Reservados DenilsonDeLeón </p>
        </footer>
        <script type="text/javascript" src="./script-login.js"></script>
    </body>
</html>