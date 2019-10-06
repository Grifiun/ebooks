/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import entidades.Revista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public static void registrarEdRevista(Connection conexion, ArrayList<String> datos, byte[] pdfBYTE) {
        //creamos la orde a enviar
       String orden = "INSERT INTO EdicionRevista (id_revista, titulo_edicion_revista,"
               + "descripcion_edicion_revista, fecha_publicacion_edicion, "
               + "estado_publicacion, revista_pdf)"
               + "VALUES (?, ?, ?, ?, ?, ?)";
        Consulta.registrarOrden(conexion, datos, orden, pdfBYTE);    //Enviamos la conexion de la DB, los datos a registrar y la orden a seguir  
        
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
        String idRev = null;
        String orden = "SELECT id_revista FROM nombre_revista="+nombreRevista;//
        ResultSet rsPrueba = Consulta.crearDeclaracionPreparadaSimple(conexion, orden).executeQuery(); //Obtenemos el resultado de la query con los datos dados       
        
        while(rsPrueba.next()){//si existe el id de la revista
            idRev = rsPrueba.getString("id_revista");
        } 
        
        rsPrueba.close();//se cierra el ResultSet
        if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
            conexion.close();
        
        return idRev;
    }
    
    public static ArrayList<Revista> obtenerRevistas(Connection conexion, boolean estado_publicacion){        
        String orden = "SELECT * FROM EdicionRevistas";
        
        return null;   
    }
    
    
}
