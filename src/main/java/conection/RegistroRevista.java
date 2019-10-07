/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import entidades.EdicionRevista;
import entidades.Revista;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author grifiun
 */
public class RegistroRevista {
    /**
     * Funcion encargada de registrar una revista
     * recibe la conexion y los datos de tipo ArrayList<String>
     * @param conexion
     * @param datos 
     */
    public static void registrarRevista(java.sql.Connection conexion, ArrayList<String> datos) {
        //creamos la orde a enviar
       String orden = "INSERT INTO Revista (nombre_revista, descripcion_revista,"
               + "costo_suscripcion, username_editor, fecha_publicacion_revista,"
               + "bloqueo_suscripcion, bloqueo_me_gusta, bloqueo_comentario)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Consulta.registrarOrden(conexion, datos, orden);    //Enviamos la conexion de la DB, los datos a registrar y la orden a seguir  
        
    }
    /**
     * 
     * @param EnlaceJDBC
     * @param datos
     * @param pdfBYTE 
     */
    public static void registrarEdRevista(Connection conexion, ArrayList<String> datos, InputStream pdf) {
        //creamos la orde a enviar
       String orden = "INSERT INTO EdicionRevista (id_revista, titulo_edicion_revista,"
               + "descripcion_edicion_revista, fecha_publicacion_edicion, "
               + "estado_publicacion, revista_pdf)"
               + "VALUES (?, ?, ?, ?, ?, ?)";
        Consulta.registrarOrden(conexion, datos, orden, pdf);    //Enviamos la conexion de la DB, los datos a registrar y la orden a seguir  
        
    }
    
    /**
     * Obtiene el idRevista de una revista
     * recibe la conexion y nombreRevista
     * @param conexion
     * @param nombreRevista
     * @return
     * @throws SQLException 
     */
    public static String idRevista(java.sql.Connection conexion, String nombreRevista) throws SQLException{
        ArrayList<String> datos = new ArrayList();
        datos.add(nombreRevista);
        String idRev = null;
        String orden = "SELECT id_revista FROM Revista WHERE nombre_revista=?";//
        ResultSet rsPrueba = Consulta.crearDeclaracionPreparada(conexion, datos, orden).executeQuery(); //Obtenemos el resultado de la query con los datos dados       
        
        while(rsPrueba.next()){//si existe el id de la revista
            idRev = rsPrueba.getString("id_revista");
        } 
        
        rsPrueba.close();//se cierra el ResultSet
        if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
            conexion.close();
        
        return idRev;
    }
    
    public static ArrayList<EdicionRevista> obtenerRevistas(Connection conexion, String estado_publicacion) throws SQLException{        
        String orden = "SELECT Revista.username_editor," +
                        "Revista.nombre_revista, Revista.costo_suscripcion," +
                        "EdicionRevista.titulo_edicion_revista," +
                        "Revista.id_revista, EdicionRevista.id_edicion_revista," +
                        "EdicionRevista.descripcion_edicion_revista," +
                        "EdicionRevista.fecha_publicacion_edicion FROM Revista INNER JOIN EdicionRevista" +
                        "ON Revista.id_revista = EdicionRevista.id_revista" +
                        "WHERE EdicionRevista.estado_publicacion="+estado_publicacion;
        ArrayList<EdicionRevista> conjuntoRevistas = null; 
        ResultSet rsPrueba = Consulta.crearDeclaracionPreparadaSimple(conexion, orden).executeQuery(); //Obtenemos el resultado de la query con los datos dados       
        
        while(rsPrueba.next()){//si existe el id de la revista            
            
            EdicionRevista revista = new EdicionRevista();
            revista.setUsernameEditor(rsPrueba.getString("username_editor"));
            revista.setNombreRevista(rsPrueba.getString("nombre_revista"));
            //revista.setCostoSuscripcion(rsPrueba.getString("costo_suscripcion"));
            revista.setTituloEdicionRevista(rsPrueba.getString("titulo_edicion_revista"));
            revista.setIdRevista(Integer.parseInt(rsPrueba.getString("id_revista")));            
            revista.setIdEdicionRevista(Integer.parseInt(rsPrueba.getString("id_edicion_revista"))); 
            revista.setDescripcionEdicionRevista("descripcion_edicion_revista");
            revista.setFechaPublicacionEdicionRevista(Date.valueOf(rsPrueba.getString("fecha_publicacion_edicion")));
            
            conjuntoRevistas.add(revista);
            revista = null;
        }
        rsPrueba.close();//se cierra el ResultSet
        if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
            conexion.close();
        
        return conjuntoRevistas;   
    }
    
    public static void validarRegistro(Connection conexion, String idEdicionRevista){
        String orden = "UPDATE EdicionRevista SET estado_publicacion=1 WHERE id_edicion_revista=?";
        
        ArrayList<String> datos = null;
        datos.add(idEdicionRevista);
        Consulta.registrarOrden(conexion, datos, orden);        
    }    
}
