/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Ignacio
 */
public class Socio {
        private Integer rut;
	private String categoria;
	private char digitoVerificador;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correoElectronico;
	private String celular;
	private char estado;
	private String sis;
	private String filial;
	private Date anioIngreso;
	
	//Atributos con claves foráneas en la base de datos
	private String codigoSocioUniversidad;
	
	//Constructores
	public Socio() {
		
	}

	public Socio(Integer rut, String categoria, char digitoVerificador, String nombres, String apellidoPaterno,
			String apellidoMaterno, String correoElectronico, String celular, char estado, String sis, String filial,
			Date anioIngreso) {
		super();
		this.rut = rut;
		this.categoria = categoria;
		this.digitoVerificador = digitoVerificador;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correoElectronico = correoElectronico;
		this.celular = celular;
		this.estado = estado;
		this.sis = sis;
		this.filial = filial;
		this.anioIngreso = anioIngreso;
	}
        
        public Socio(Integer rut, String categoria, char digitoVerificador, String nombres, String apellidoPaterno,
			 String correoElectronico, String celular, char estado, String sis, String filial,
			Date anioIngreso) {
		super();
		this.rut = rut;
		this.categoria = categoria;
		this.digitoVerificador = digitoVerificador;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.correoElectronico = correoElectronico;
		this.celular = celular;
		this.estado = estado;
		this.sis = sis;
		this.filial = filial;
		this.anioIngreso = anioIngreso;
	}

	public Socio(Integer rut, String categoria, char digitoVerificador, String nombres, String apellidoPaterno,
			String apellidoMaterno, String correoElectronico, String celular, char estado, String sis, String filial,
			Date anioIngreso, String codigoSocioUniversidad) {
		super();
		this.rut = rut;
		this.categoria = categoria;
		this.digitoVerificador = digitoVerificador;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.correoElectronico = correoElectronico;
		this.celular = celular;
		this.estado = estado;
		this.sis = sis;
		this.filial = filial;
		this.anioIngreso = anioIngreso;
		this.codigoSocioUniversidad = codigoSocioUniversidad;
	}
        
        public Socio(Integer rut, String categoria, char digitoVerificador, String nombres, String apellidoPaterno,
			 String correoElectronico, String celular, char estado, String sis, String filial,
			Date anioIngreso, String codigoSocioUniversidad) {
		super();
		this.rut = rut;
		this.categoria = categoria;
		this.digitoVerificador = digitoVerificador;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.correoElectronico = correoElectronico;
		this.celular = celular;
		this.estado = estado;
		this.sis = sis;
		this.filial = filial;
		this.anioIngreso = anioIngreso;
		this.codigoSocioUniversidad = codigoSocioUniversidad;
	}

	//Getters y Setters
	public Integer getRut() {
		return rut;
	}

	public void setRut(Integer rut) {
		this.rut = rut;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public char getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(char digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String getSis() {
		return sis;
	}

	public void setSis(String sis) {
		this.sis = sis;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public Date getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioIngreso(Date anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	public String getCodigoSocioUniversidad() {
		return codigoSocioUniversidad;
	}

	public void setCodigoSocioUniversidad(String codigoSocioUniversidad) {
		this.codigoSocioUniversidad = codigoSocioUniversidad;
	}
        
  /*Consultas a la base de datos
   *
   *Métodos para las diferentes inserciones de los socios:
   * 
  */
        
        
      public boolean agregar(Socio nuevo){
          String sentencia = "INSERT INTO tbl_socio (rut,  categoria,  dv,  nombres,  apellido_paterno," +
			  "apellido_materno,  correo,  celular,  estado,  sis,  filial," +
			  "fecha_ingreso) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
          
          try{
              if(!buscarSocio(nuevo.getRut())){
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setInt(1, nuevo.getRut());
              ps.setString(2, nuevo.getCategoria());
              ps.setString(3, String.valueOf(nuevo.getDigitoVerificador()));
              ps.setString(4, nuevo.getNombres());
              ps.setString(5, nuevo.getApellidoPaterno());
              ps.setString(6, nuevo.getApellidoMaterno());
              ps.setString(7, nuevo.getCorreoElectronico());
              ps.setString(8, nuevo.getCelular());
              ps.setString(9, String.valueOf(nuevo.getEstado()));
              ps.setString(10, nuevo.getSis());
              ps.setString(11, nuevo.getFilial());
              ps.setDate(12, nuevo.getAnioIngreso());
              return true;
              }else{
                  System.out.println("El socio ya existe");
              }
          }catch (SQLException e){
              System.out.println("No se pudo agregar");
          }
          
          return false;
      }  
      
      public boolean buscarSocio(int rut){
         String sentencia = "SELECT * FROM tbl_socio WHERE rut = ?";
         ResultSet rs;
         try{
             PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
             ps.setInt(1, rut);
             rs = ps.executeQuery();
             
             if(rs.next()){
                 System.out.println("Encontrado");
                 return true;
             }else{
                 System.out.println("No se encontró");
                 return false;
             }
         }catch(SQLException e){
             System.out.println("No se pudo agregar");
         }
         
         return false;
      }
}
