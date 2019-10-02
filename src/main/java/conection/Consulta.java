/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grifiun
 */
public class Consulta {
    static PreparedStatement declaracionPreparada = null;
    static ResultSet resultado = null;
    public static boolean consultaExistenciaUsuario(java.sql.Connection conexion, String username){        
        declaracionPreparada = null;
        resultado = null;
        try {            
            declaracionPreparada = conexion.prepareStatement("SELECT username FROM Usuario WHERE username = ?");
            declaracionPreparada.setString(1, username);
            resultado = declaracionPreparada.executeQuery();
            if(resultado.next()){
                 System.out.println("EXISTE");
                 conexion.close();
                 return true;
            }
            else{
                System.out.println("no existe");
                conexion.close();
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("\n\n\n"+ex);
        }
        return false;
    }
    
    public static boolean login(java.sql.Connection conexion, String pass, String username) throws SQLException{
        ResultSet rsPrueba =  selectDML(conexion, "SELECT pass FROM Usuario WHERE username='"+username+"'");
        boolean aux = false;
        while(rsPrueba.next()){
            String passAux = rsPrueba.getString("pass");
            if(passAux.endsWith(pass)){
                aux = true;
            }
            else{
                aux = false;
            }
        }
        conexion.close();
        System.out.println("eS: "+aux);
        return aux;
    }
    
    public static ResultSet selectDML(java.sql.Connection conexion, String orden){        
        try {
            declaracionPreparada = null;
            resultado = null;
            
            declaracionPreparada = conexion.prepareStatement(orden);
            resultado = declaracionPreparada.executeQuery();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("\n\n\n"+ex);
            return null;
        }                    
        
    }
    
    
    
    
}


