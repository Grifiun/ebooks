/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import static conection.Consulta.registrarOrden;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author grifiun
 */
public class RegistroUsuario {
     
    /**
     * Funcion encargada de registrar un nuevo usuario
     * Recibe los parametros de conexion y datos
     * de tipo java.sql.Connection y ArrayList<String>
     * respectivamente.
     * @param conexion
     * @param datos 
     */
    public static void registrarUsuario(java.sql.Connection conexion, ArrayList<String> datos){        
        String orden = "INSERT INTO Usuario (username, pass, nombre, apellido," //Creamos la orden a enviar
                + "edad, pais, ciudad, descripcion, hobbie, tema_interes, rol)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Consulta.registrarOrden(conexion, datos, orden);    //Enviamos la conexion de la DB, los datos a registrar y la orden a seguir                 
    }
    
    
    public static String rol(java.sql.Connection conexion, ArrayList<String> datos) throws SQLException{
        String rol = null;        
        String orden = "SELECT rol FROM Usuario WHERE username=?";//        
        
        ResultSet rsPrueba;
        rsPrueba = Consulta.crearDeclaracionPreparada(conexion, datos, orden).executeQuery();
        while(rsPrueba.next()){//si existe el id de la revista
            rol = rsPrueba.getString("rol");
        }   
        //se cierra el ResultSet
        
        if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
            conexion.close();
        
        return rol;
    }
    
}
