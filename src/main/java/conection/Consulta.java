/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grifiun
 */
public class Consulta {
    static PreparedStatement declaracionPreparada = null;
    
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
        ResultSet rsPrueba = crearDeclaracionPreparada(conexion, datos, orden).executeQuery(); //Obtenemos el resultado de la query con los datos dados       
        while(rsPrueba.next()){//si existe el usuario se verifica la contrasena
            String passAux = rsPrueba.getString("pass");//variable auxiliar que guarda el valor de la contrasena
            if(passAux.equals(pass)){//si la contrasena es igual, entonces          
                aux = true;//el booleano es verdadero
            }
        }
        System.out.println("Estado RQuery: "+conexion.isClosed());
            if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
                conexion.close();
        System.out.println("eS: "+aux);
        return aux;//retornamos el booleano
    }
    
    /**
     * Funcion encargada de registrar un nuevo usuario
     * Recibe los parametros de conexion y datos
     * de tipo java.sql.Connection y ArrayList<String>
     * respectivamente.
     * @param conexion
     * @param datos 
     */
    public static void registrarUsuario(java.sql.Connection conexion, ArrayList<String> datos){
        try {
            declaracionPreparada = null; //Le damos un valor nulo a la declaracion preparada          
            declaracionPreparada = conexion.prepareStatement("INSERT INTO Usuario (username, pass, nombre, apellido,"
                    + "edad, pais, ciudad, descripcion, hobbie, tema_interes, rol)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); //asignamos el select con valores a asignar            
           
            for(int i = 1; i <= 11; i++){//asignamos los valores del arrayList datos en cada campo del select
                String aux = null;                
                switch(i){
                    case 5: //Cuando i sea 5, hay que realizar un guardado de un entero
                        aux = datos.get(i - 1);
                        System.out.println("paso 5: "+Integer.parseInt(aux));
                        declaracionPreparada.setInt(5, Integer.parseInt(aux));                        
                        break;
                    case 11:
                        System.out.println("paso 11: Editor");
                        declaracionPreparada.setString(11, "Editor");
                        break;
                    default://por defecto nos guardará los datos como String
                        aux = datos.get(i - 1);
                        System.out.println("paso "+i+" : "+aux);
                        declaracionPreparada.setString(i, aux);
                        break;   
                }                
            }            
            declaracionPreparada.executeUpdate(); //Ejecutamos la orden 
            conexion.close();//Cerramos la conexion
        } catch (SQLException ex) {
            System.out.println("\n\n\n"+ex); //Imprimimos el error en consola en caso de fallar           
        }     
    }
      
   /**
     * Funcion encargada de realizar peticiones de tipo Update
     * Recibe los parametros de conexion, datos y orden
     * de tipo java.sql.Connection, ArrayList<String> y String
     * @param conexion
     * @param datos
     * @param orden
     * @return 
     */
    public static void registrarOrden(java.sql.Connection conexion, ArrayList<String> datos, String orden){
    try {
           crearDeclaracionPreparada(conexion, datos, orden).executeUpdate(); //Ejecutamos la orden de tipo Query creada a partir de la orden y datos dados
           if(conexion.isClosed() == false)//si la conexion está abierta la cerramos
                conexion.close();
        } catch (SQLException ex) {
            System.out.println("\n\n\n"+ex); //Imprimimos el error en consola en caso de fallar           
        }  
    }    

    /**
     * Funcion encargada de crear y retornar una declaracion preparada con la
     * orden "orden" de tipo String, con los datos dados en el arrayList
     * de tipo ArrayList<String> y en la conexion "conexion" de tipo 
     * java.sql.Connection
     * @param conexion
     * @param datos
     * @param orden
     * @return 
     */
    private static PreparedStatement crearDeclaracionPreparada(java.sql.Connection conexion, ArrayList<String> datos, String orden){
        try {
            PreparedStatement dp = null;
            dp = conexion.prepareStatement(orden); //asignamos el select que trae el String orden         
            int esUnEntero;
            for(int i = 1; i <= datos.size(); i++){//asignamos los valores del arrayList datos en cada campo del select
                String aux = null;   
                esUnEntero = isEntero(datos.get(i - 1));//Revisamos si la cadena de datos.get(i) es un entero
                switch(esUnEntero){
                    case 1: //Cuando es 1 significa que el dato dentro de datos.get(i) es un entero, por tanto se rellena el campo como tal
                        aux = datos.get(i - 1);
                        dp.setInt(i, Integer.parseInt(aux));                        
                        break;
                    case 0://Cuando es 0 significa que no es un entero y se rellena el campo como String
                        aux = datos.get(i - 1);
                        dp.setString(i, aux);
                        break;
                }                
            }
            return dp;
        } catch (SQLException ex) {
            System.out.println("\n\n\n"+ex); //Imprimimos el error en consola en caso de fallar           
        } 
        return null;
    }
    
    private static int isEntero(String palabra) {
        return 0;
    }
}


