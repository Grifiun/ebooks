/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conection.Consulta;
import conection.EnlaceJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
        
        try {
                if(Consulta.login(EnlaceJDBC.EnlaceJDBC(), pass, username) == true){
                    RequestDispatcher despachar = request.getRequestDispatcher("jsp/home.jsp");
                    despachar.forward(request, response);
                }             
                else{
                    
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
