/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conection.Consulta;
import conection.EnlaceJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author grifiun
 */
@WebServlet(urlPatterns = {"/ControladorCrearUsuario"})
public class ControladorCrearUsuario extends HttpServlet {

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

        String[] datos = new String[11];
        datos = null;
        String aux = null;
        String[] identificador = {"username", "pass", "nombre", "apellido", "edad", "pais", "ciudad", "descripcion", "hobbies", "temas_interes"};
        for(int i = 0; i < 10; i++){
            aux = request.getParameter(identificador[i]);
            System.out.println(aux);
            datos[i] = aux;
        }        
        datos[10] = "Lector";
        try {
            Consulta.registrarUsuario(EnlaceJDBC.EnlaceJDBC(), datos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
