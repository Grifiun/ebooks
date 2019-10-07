/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conection.Consulta;
import conection.EnlaceJDBC;
import conection.RegistroUsuario;
import conection.RevisarLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author grifiun
 */
@WebServlet(urlPatterns = {"/ControladorLogin"})
public class ControladorLogin extends HttpServlet {
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        String username = request.getParameter("username");      
        String pass = request.getParameter("pass");
        LocalDate fechaSistema = LocalDate.now();
        
        HttpSession session = request.getSession();
        session.setAttribute("username_sesion", request.getParameter("username"));        
        session.setAttribute("fecha_sistema", fechaSistema);
        
        try {
                if(RevisarLogin.login(EnlaceJDBC.EnlaceJDBC(), username, pass) == true){
                    String rol = RegistroUsuario.rol(EnlaceJDBC.EnlaceJDBC(), username);
                    if(rol.equals("Editor")){
                        RequestDispatcher despachar = request.getRequestDispatcher("jsp/home-editor.jsp");
                        despachar.forward(request, response);
                    }                  
                    if(rol.equals("Administrador")){
                        RequestDispatcher despachar = request.getRequestDispatcher("jsp/home-administrador.jsp");
                        despachar.forward(request, response);
                    } 
                    if(rol.equals("Lector")){
                        RequestDispatcher despachar = request.getRequestDispatcher("jsp/home.jsp");
                        despachar.forward(request, response);
                    } 
                    
                    
                }             
                else{
                    RequestDispatcher despachar = request.getRequestDispatcher("index.jsp");
                    despachar.forward(request, response);
                }


        } catch (ClassNotFoundException ex) {
        Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
        Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
        Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {      
        Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }          

    }
}
