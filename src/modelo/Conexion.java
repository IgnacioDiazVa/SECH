/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Ignacio
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conexion;
    
    private Conexion(){
        
    }


    public static Connection obtenerInstancia() {
        try {
            if (conexion == null) {
                Runtime.getRuntime().addShutdownHook(new getClose());
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/database2018?autoReconnect=true&useSSL=false", "root", "root");
            }
            return conexion;
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException("Conexión fallida", e);
        }
    }
    
    static class getClose extends Thread{
        @Override
        public void run() {
            try{
                Connection conn = Conexion.obtenerInstancia();
                conn.close();
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }
        
        
    }
}
