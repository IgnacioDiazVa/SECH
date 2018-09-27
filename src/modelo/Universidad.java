/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author Ignacio
 */
public class Universidad {
        private String codigoIngreso;
	private Date anioIngresoU;
	private String nombreUniversidad;
	private String sede;
	
	//Constructores
	public Universidad() {
		
	}

	public Universidad(String codigoIngreso, Date anioIngresoU, String nombreUniversidad, String sede) {
		super();
		this.codigoIngreso = codigoIngreso;
		this.anioIngresoU = anioIngresoU;
		this.nombreUniversidad = nombreUniversidad;
		this.sede = sede;
	}
	
	//Getters y Setters
	public String getCodigoIngreso() {
		return codigoIngreso;
	}

	public void setCodigoIngreso(String codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}

	public Date getAnioIngresoU() {
		return anioIngresoU;
	}

	public void setAnioIngresoU(Date anioIngresoU) {
		this.anioIngresoU = anioIngresoU;
	}

	public String getNombreUniversidad() {
		return nombreUniversidad;
	}

	public void setNombreUniversidad(String nombreUniversidad) {
		this.nombreUniversidad = nombreUniversidad;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
        
        
        public boolean agregar(Universidad nuevo){
          String sentencia = "INSERT INTO tbl_universidad (codigo_ingreso,  anio_ingreso,  nombre_universidad,  sede)" +
			  "VALUES(?,?,?,?)";
          
          try{
              if(!buscarEstudiantil(nuevo.getCodigoIngreso())){
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setString(1, nuevo.getCodigoIngreso());
              ps.setDate(2, nuevo.getAnioIngresoU());
              ps.setString(3, nuevo.getNombreUniversidad());
              ps.setString(4, nuevo.getSede());
              ps.execute();
              return true;
              }else{
                  System.out.println("El socio ya existe");
              }
          }catch (SQLException e){
              System.out.println("No se pudo agregar");
          }
          
          return false;
      }  
      
      public boolean buscarEstudiantil(String codigoIngreso){
         String sentencia = "SELECT * FROM tbl_universidad WHERE codigo_ingreso = ?";
         ResultSet rs;
         try{
             PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
             ps.setString(1, codigoIngreso);
             rs = ps.executeQuery();
             
             if(rs.next()){
                 System.out.println("Encontrado");
                 return true;
             }else{
                 System.out.println("No se encontró");
                 return false;
             }
         }catch(SQLException e){
             System.out.println("No se pudo verificar");
         }
         
         return false;
      }
}
