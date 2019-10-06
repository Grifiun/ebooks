/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author grifiun
 */
public class RevisarLogin {
    
    /**
     * Funcion encargada de revisar la existencia del usuario 
     * con username "username" y con contrasena "pass". Si el
     * usuario esta registrado y tiene la contrasena buena
     * se retorna un booleano con valor verdadero, en caso contrario
     * se retorna un booleano falso
     * @param conexion
     * @param username
     * @param pass
     * @return
     * @throws SQLException 
     */   
    public static boolean login(java.sql.Connection conexion, String username, String pass) throws SQLException{
        String orden = "SELECT pass FROM Usuario WHERE username=?";//Creamos la orden
        ArrayList<String> datos = new ArrayList();//creamos un ArrayList de tipo String
       
        datos.add(username);//Agregamos "username" al ArrayList datos
        boolean aux = false;//creamos un booleano auxiliar con valor negativo
        ResultSet rsPrueba = Consulta.crearDeclaracionPreparada(conexion, datos, orden).executeQuery(); //Obtenemos el resultado de la query con los datos dados       
        while(rsPrueba.next()){//si existe el usuario se verifica la contrasena
            String passAux = rsPrueba.getString("pass");//variable auxiliar que guarda el valor de la contrasena
            if(passAux.equals(pass)){//si la contrasena es igual, entonces          
                aux = true;//el booleano es verdadero
            }
        }     
        
        rsPrueba.close();
        
            if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
                conexion.close();
            
        
        return aux;//retornamos el booleano
    }
}
