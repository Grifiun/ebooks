/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conection.EnlaceJDBC;
import conection.RegistroCategoria;
import conection.RegistroRevista;
import conection.RegistroTag;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author grifiun
 */

@MultipartConfig (maxFileSize = 16177215)//16MB
@WebServlet(urlPatterns = {"/CrearRevista"})
public class CrearRevista extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

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
        try {
            /**
             * Primero creamos la revista como tal (no las ediciones ni el guardado del archivo pdf en la DB)
             * para crear una revista tenemos que tener los siguientes datos: (* son datos obtenidos de la Session)
             * username_editor *
             * nombre_revista
             * descripcion_revista
             * fecha_publicacion_revista *
             * costo_suscripcion
             * bloqueo_suscripcion
             * bloqueo_me_gusta
             * bloqueo_comentario
             */
            ArrayList <String> datos = new ArrayList();
            HttpSession session = request.getSession();
            String bloqCom, bloqSus, bloqMG;
            bloqSus = request.getParameter("rbSuscripcion");
            bloqCom = request.getParameter("rbComentario");
            bloqMG = request.getParameter("rbMeGusta");
            String usernameEditor = (String) session.getAttribute("username_sesion");//username del editor
            String fechaRevista = (String) session.getAttribute("fecha_sistema");//fecha del sistema (definido)
           
            String[] identificador = {"nombre_revista", "descripcion_revista", "costo_suscripcion"};
            
            
            for(int i = 0; i < identificador.length; i++){
                String aux = null;
                aux = request.getParameter(identificador[i]);
                datos.add(aux);
            }
            
            datos.add(usernameEditor);//username_editor
            datos.add(fechaRevista);//agregamos la fecha a datos
            datos.add(bloqSus);//bloqueo de suscaripcion
            datos.add(bloqCom);//bloqueo de coment
            datos.add(bloqMG);//bloque de MG
            
            //Registramos la revista
            RegistroRevista.registrarRevista(EnlaceJDBC.EnlaceJDBC(), datos);
            
            /**
             * AHORA PROCEDEMOS A REGISTRAR LA CATEGORIA DE LA REVISTA
             * Necesitamos:
             * id_revista
             * id_categoria  (es la seleccionada en los check box)
             * categoria
             */
            String[] idCategoriaSeleccionadas = request.getParameterValues("categoriaElegido");//Obtenemos el id de las categorias seleccionadas en los checkbox
            String idRevista = null;
            idRevista = RegistroRevista.idRevista(EnlaceJDBC.EnlaceJDBC(), datos.get(0));
            String categoria = null;
            for(int i=0; i < idCategoriaSeleccionadas.length; i++){
                datos = null;
                categoria = null;
                
                //Obtenemos la categoria por el id en turno
                categoria = RegistroCategoria.obtenerCategoriaPorId(EnlaceJDBC.EnlaceJDBC(), idCategoriaSeleccionadas[i]);
                //agregamos los datos al ArrayList datos
                datos.add(idRevista);
                datos.add(idCategoriaSeleccionadas[i]);
                datos.add(categoria);
                
                //Registramos las categorias
                RegistroCategoria.registrarCategoria(EnlaceJDBC.EnlaceJDBC(), datos);
                
            }
            
            
            /**
             * GUARDAMOS LA EDICION DE LA REVISTA
             * DATOS A TENER:
             * id_revista (lo tenemos)
             * titulo_edicion_revista
             * descripcion:edicion_revista
             * fecha_publicacion_edicion (lo tenemos)
             * revista_pdf
             * estado_publicacion (hay que crearla)
             */           
            datos = null;
            String tituloEd = request.getParameter("titulo_edicion");
            String descEd = request.getParameter("descripcion_edicion_revista");
            String estado = "0";//para indicar que aun no esta autorizado por un administrador su publicacion
            byte[] pdfBYTE = null;//Buffer
            Part pdf;
            pdf = request.getPart("archivopdf"); 
            int pdfSize = (int) pdf.getSize();
            
            datos.add(idRevista);
            datos.add(tituloEd);
            datos.add(descEd);
            datos.add(fechaRevista);
            datos.add(estado);
            
            RegistroRevista.registrarEdRevista(EnlaceJDBC.EnlaceJDBC(), datos, pdfBYTE);
            
            /*
            if(pdfSize > 0){
                pdfBYTE = new byte[pdfSize];
                try(DataInputStream dis=new DataInputStream(pdf.getInputStream())){
                    dis.readFully(pdfBYTE);
                }
            }
            */
            
            /**
             * POR ULTIMO PROCEDEMOS A REGISTRAR LOS TAGS   
             */
            datos = null;
            String tags = request.getParameter("tag");
            datos.add(idRevista);
            datos.add(tags);
            RegistroTag.registrarTags(EnlaceJDBC.EnlaceJDBC(), datos);
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearRevista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CrearRevista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CrearRevista.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearRevista.class.getName()).log(Level.SEVERE, null, ex);
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
