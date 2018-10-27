/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Ignacio
 */
public class Laboral {
        private String direccion;
	private Integer piso;
	private String oficina;
	private Integer numeroTelefono;
	private String referencia;
	private String sitioWeb;
	private String nombreLaboral;
        
	
	//Atributos con claves foráneas en la base de datos
	private Integer laboralRut;
	private String laboralCategoria;
	private Integer codigoComunaLaboral;
	
	//Constructores
	public Laboral() {		
	}
        
        public Laboral(String direccion, Integer numeroTelefono,
			 Integer laboralRut, String laboralCategoria,
			Integer codigoComunaLaboral) {
		super();
		this.direccion = direccion;
		this.numeroTelefono = numeroTelefono;
		this.laboralRut = laboralRut;
		this.laboralCategoria = laboralCategoria;
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
        
        public Laboral(String direccion, Integer piso, Integer numeroTelefono,
			 Integer laboralRut, String laboralCategoria,
			Integer codigoComunaLaboral) {
		super();
		this.direccion = direccion;
                this.piso = piso;
		this.numeroTelefono = numeroTelefono;
		this.laboralRut = laboralRut;
		this.laboralCategoria = laboralCategoria;
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
        
        public Laboral(String direccion, String oficina, Integer numeroTelefono,
			 Integer laboralRut, String laboralCategoria,
			Integer codigoComunaLaboral) {
		super();
		this.direccion = direccion;
                this.oficina = oficina;
		this.numeroTelefono = numeroTelefono;
		this.laboralRut = laboralRut;
		this.laboralCategoria = laboralCategoria;
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
        

	public Laboral(String direccion, Integer piso, String oficina, Integer numeroTelefono, String referencia,
			String sitioWeb, String nombreLaboral) {
		super();
		this.direccion = direccion;
		this.piso = piso;
		this.oficina = oficina;
		this.numeroTelefono = numeroTelefono;
		this.referencia = referencia;
		this.sitioWeb = sitioWeb;
		this.nombreLaboral = nombreLaboral;
	}

	public Laboral(String direccion, Integer piso, String oficina, Integer numeroTelefono, String referencia,
			String sitioWeb, String nombreLaboral, Integer laboralRut, String laboralCategoria,
			Integer codigoComunaLaboral) {
		super();
		this.direccion = direccion;
		this.piso = piso;
		this.oficina = oficina;
		this.numeroTelefono = numeroTelefono;
		this.referencia = referencia;
		this.sitioWeb = sitioWeb;
		this.nombreLaboral = nombreLaboral;
		this.laboralRut = laboralRut;
		this.laboralCategoria = laboralCategoria;
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
	
	//Getters y Setters
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getNombreLaboral() {
		return nombreLaboral;
	}

	public void setNombreLaboral(String nombreLaboral) {
		this.nombreLaboral = nombreLaboral;
	}

	public Integer getLaboralRut() {
		return laboralRut;
	}

	public void setLaboralRut(Integer laboralRut) {
		this.laboralRut = laboralRut;
	}

	public String getLaboralCategoria() {
		return laboralCategoria;
	}

	public void setLaboralCategoria(String laboralCategoria) {
		this.laboralCategoria = laboralCategoria;
	}

	public Integer getCodigoComunaLaboral() {
		return codigoComunaLaboral;
	}

	public void setCodigoComunaLaboral(Integer codigoComunaLaboral) {
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
        
        public boolean agregar(Laboral nuevo){
          String sentencia = "INSERT INTO tbl_laboral (direccion,  piso,  oficina,  telefono,  referencia," +
			  "sitio_web,  tbl_socio_rut,  tbl_socio_categoria,  tbl_comuna_codigo_comuna,  nombre_laboral)" +
			  "VALUES(?,?,?,?,?,?,?,?,?,?)";
          
          try{
              if(!buscarSocioLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setString(1, nuevo.getDireccion());
              ps.setInt(2, nuevo.getPiso());
              ps.setString(3, nuevo.getOficina());
              ps.setInt(4, nuevo.getNumeroTelefono());
              ps.setString(5, nuevo.getReferencia());
              ps.setString(6, nuevo.getSitioWeb());
              ps.setInt(7, nuevo.getLaboralRut());
              ps.setString(8, nuevo.getLaboralCategoria());
              ps.setInt(9, nuevo.getCodigoComunaLaboral());
              ps.setString(10, nuevo.getNombreLaboral());
              ps.execute();
              return true;
              }else{
                  System.out.println("Este registro de trabajo ya existe");
              }
          }catch (SQLException e){
              System.out.println("No se pudo agregar");
              System.out.println ("El error es: " + e.getMessage());
              e.printStackTrace();
          }
          
          return false;
      }  
        
        public boolean agregarSinPiso(Laboral nuevo){
          String sentencia = "INSERT INTO tbl_laboral (direccion, oficina,  telefono,  referencia," +
			  "sitio_web,  tbl_socio_rut,  tbl_socio_categoria,  tbl_comuna_codigo_comuna,  nombre_laboral)" +
			  "VALUES(?,?,?,?,?,?,?,?,?)";
          
          try{
              if(!buscarSocioLaboral(nuevo.getDireccion(), nuevo.getLaboralRut())){
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setString(1, nuevo.getDireccion());
              ps.setString(2, nuevo.getOficina());
              ps.setInt(3, nuevo.getNumeroTelefono());
              ps.setString(4, nuevo.getReferencia());
              ps.setString(5, nuevo.getSitioWeb());
              ps.setInt(6, nuevo.getLaboralRut());
              ps.setString(7, nuevo.getLaboralCategoria());
              ps.setInt(8, nuevo.getCodigoComunaLaboral());
              ps.setString(9, nuevo.getNombreLaboral());
              ps.execute();
              return true;
              }else{
                  System.out.println("Este registro de trabajo ya existe");
              }
          }catch (SQLException e){
              System.out.println("No se pudo agregar");
          }
          
          return false;
      }  
      
      public boolean buscarSocioLaboral(String direccion, int laboralRut){
         String sentencia = "SELECT * FROM tbl_laboral WHERE tbl_socio_rut = ? AND direccion = ?";
         ResultSet rs;
         try{
             PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
             ps.setInt(1, laboralRut);
             ps.setString(2, direccion);
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
      
      public int codigoComuna(String comuna){
          String sentencia = "SELECT codigo_comuna FROM tbl_comuna WHERE nombre_comuna = ?";
          ResultSet rs;
          int numero;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setString(1, comuna);
              rs = ps.executeQuery();
              
              if(rs.next()){
                  System.out.println("Se ha encontrado la comuna");
                  numero = rs.getInt(1);
                  return numero;
              }else{
                  System.out.println("No coincide con ningún regitro");
                  return 0;
              }
          }catch(SQLException e){
              System.out.println("No se pudo verificar");
          }
          return 0;
      }
      
      public ArrayList<Laboral> listLaboral(int rut){
          String sentencia = "SELECT * FROM tbl_laboral where tbl_socio_rut=?"; 
          ArrayList listaLaboral = new ArrayList();
          Laboral laboral;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setInt(1, rut);
              rs = ps.executeQuery();
              while(rs.next()){
                  laboral = new Laboral();
                  laboral.setDireccion(rs.getString(1));
                  laboral.setPiso(rs.getInt(2));
                  laboral.setOficina(rs.getString(3));
                  laboral.setNumeroTelefono(rs.getInt(4));
                  laboral.setReferencia(rs.getString(5));
                  laboral.setSitioWeb(rs.getString(6));
                  laboral.setLaboralRut(rs.getInt(7));
                  laboral.setLaboralCategoria(rs.getString(8));
                  laboral.setCodigoComunaLaboral(rs.getInt(9));
                  laboral.setNombreLaboral(rs.getString(10));
                  listaLaboral.add(laboral);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaLaboral;
      }
}
