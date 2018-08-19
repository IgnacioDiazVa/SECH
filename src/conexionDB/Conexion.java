/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionDB;

/**
 *
 * @author Ignacio
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
     private static Connection conexion;
    
    private Conexion(){}
            
    public static Connection obtenerInstancia()
    {
        if(conexion == null){
            String url = "jdbc:mysql:thin:@localhost:1521:xe";
            String user = "root";
            String pass = "root";
            System.out.println("Proceso de Coneccion...");
            try {
                conexion = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexión realizada a la base de datos con éxito.");
            }catch(SQLException e) {
                System.out.println("Error!, conexión fallida a la base de datos.");
            }
        }
        return conexion;
    }
}
