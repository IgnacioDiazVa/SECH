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
public class Actividad {
        private Date fechaInicio;
	private Date fechaTermino;
	private String estadoActividad;
	private String motivo;
	
	//Atributos con claves foráneas en la base de datos
	private Integer actividadRut;
	private String actividadCategoria;
	
	//Constructores
	public Actividad() {
	}
	
	public Actividad(Date fechaInicio, Date fechaTermino, String estadoActividad, String motivo, Integer actividadRut,
			String actividadCategoria) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.estadoActividad = estadoActividad;
		this.motivo = motivo;
		this.actividadRut = actividadRut;
		this.actividadCategoria = actividadCategoria;
	}
	
	public Actividad(Date fechaInicio, Date fechaTermino, String estadoActividad, String motivo) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.estadoActividad = estadoActividad;
		this.motivo = motivo;
	}
	
	//Getters and Setters
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaTermino() {
		return fechaTermino;
	}
	
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	
	public String getEstadoActividad() {
		return estadoActividad;
	}
	
	public void setEstadoActividad(String estadoActividad) {
		this.estadoActividad = estadoActividad;
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public Integer getActividadRut() {
		return actividadRut;
	}
	
	public void setActividadRut(Integer actividadRut) {
		this.actividadRut = actividadRut;
	}
	
	public String getActividadCategoria() {
		return actividadCategoria;
	}
	
	public void setActividadCategoria(String actividadCategoria) {
		this.actividadCategoria = actividadCategoria;
	}
        
        //En la tabla de actividad de la base de datos hay que arreglar la llave primaria para que sea estado_actividad y socio rut, en vez de solo socio rut
        //O simplemente borrar una vez que estado_finalizado llegue a finalizado
        
        public boolean agregarActividad(Actividad nuevo){
          String sentencia = "INSERT INTO tbl_actividad (fecha_incio_inactividad, fecha_termino_inactividad, estado_actividad, motivo," +
			  "tbl_socio_rut, tbl_socio_categoria)" +
			  "VALUES(?,?,?,?,?,?)";
          
          try{
              if(!buscar(nuevo)){
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setDate(1, nuevo.getFechaInicio());
              ps.setDate(2, nuevo.getFechaTermino());
              ps.setString(3, nuevo.getEstadoActividad());
              ps.setString(4, nuevo.getMotivo());
              ps.setInt(5, nuevo.getActividadRut());
              ps.setString(6, nuevo.getActividadCategoria());
              ps.execute();
              return true;
              }else{
                  System.out.println("El socio ya existe");
              }
          }catch (SQLException e){
              System.out.println("No se pudo agregar");
              System.out.println ("El error es: " + e.getMessage());
              e.printStackTrace();
          }
          
          return false;
      } 
        
        public boolean buscar(Actividad nuevo){
         String sentencia = "SELECT * FROM tbl_actividad WHERE tbl_socio_rut = ? and estado_actividad = ?";
         ResultSet rs;
         try{
             PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
             ps.setInt(1, nuevo.getActividadRut());
             ps.setString(2, "En proceso");
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
        
        public Actividad buscarRegistro(int rut){
         String sentencia = "SELECT * FROM tbl_actividad WHERE tbl_socio_rut = ?";
         ResultSet rs;
         Actividad nuevo = new Actividad();
         try{
             PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
             ps.setInt(1, rut);
             rs = ps.executeQuery();
             
             if(rs.next()){
                 nuevo.setFechaInicio(rs.getDate("fecha_incio_inactividad"));
                 nuevo.setFechaTermino(rs.getDate("fecha_termino_inactividad"));
                 nuevo.setEstadoActividad(rs.getString("estado_actividad"));
                 nuevo.setMotivo(rs.getString("motivo"));
                 nuevo.setActividadRut(rs.getInt("tbl_socio_rut"));
                 nuevo.setActividadCategoria(rs.getString("tbl_socio_categoria"));
                 return nuevo;
             }else{
                 System.out.println("No se encontró");
                 return null;
             }
         }catch(SQLException e){
             System.out.println("No se pudo verificar");
         }
         
         return null;
      }
        
        public boolean buscar(int rut){
         String sentencia = "SELECT * FROM tbl_actividad WHERE tbl_socio_rut = ?";
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
             System.out.println("No se pudo verificar");
         }
         
         return false;
      }

}
