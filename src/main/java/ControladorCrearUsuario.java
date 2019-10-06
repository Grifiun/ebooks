/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conection.EnlaceJDBC;
import conection.RegistroUsuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
        
        ArrayList <String> datos = new ArrayList();//ArrayList de tipo String que almacena los datos del usuario
        //Creamos un arreglo de tipo String con los identificadores de los datos del form
        String[] identificador = {"username", "pass", "nombre", "apellido", "edad", 
                                    "pais", "ciudad", "descripcion", "hobbies", "temas_interes"};
        int posRol;//creamos una variable que se usara para definir el rol 
        for(int i = 0; i < 10; i++){
            String aux = null;//creamos una variable auxiliar de tipo String
            aux = request.getParameter(identificador[i]);//agregamos a la variable auxiliar el valor del identificador
            datos.add(aux);//agregamos la variable auxiliar al arreglo datos
        }       
        
        String rol = null;        
        posRol = Integer.parseInt(request.getParameter("rol"));
        if(posRol == 1){//Si la posicion de select es 1 entonces es un Lector
            rol = "Lector";
        }
        if(posRol == 2){//Si la posicion de select es 2 entonces es un Editor
            rol = "Editor";
        }
        
        datos.add(rol);//agregamos al ArrayList datos
        
        try {
            RegistroUsuario.registrarUsuario(EnlaceJDBC.EnlaceJDBC(), datos);//registrmos el usuario
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ControladorCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        RequestDispatcher despachar = request.getRequestDispatcher("jsp/home-editor.jsp");
        despachar.forward(request, response);
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
