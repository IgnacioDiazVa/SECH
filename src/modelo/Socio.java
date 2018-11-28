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
import java.util.ArrayList;
import jdk.nashorn.internal.objects.NativeError;


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
      
      public boolean agregarEstudiantil(Socio nuevo){
          String sentencia = "INSERT INTO tbl_socio (rut,  categoria,  dv,  nombres,  apellido_paterno," +
			  "apellido_materno,  correo,  celular,  estado,  sis,  filial," +
			  "fecha_ingreso, tbl_universidad_codigo_ingreso) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
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
              ps.setString(13, nuevo.getCodigoSocioUniversidad());
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
             System.out.println("No se pudo verificar");
         }
         
         return false;
      }
      
      public boolean buscar(Socio nuevo){
         String sentencia = "SELECT * FROM tbl_socio WHERE rut = ?";
         ResultSet rs;
         try{
             PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
             ps.setInt(1, nuevo.getRut());
             rs = ps.executeQuery();
             
             if(rs.next()){
                 nuevo.setNombres(rs.getString("nombres"));
                 nuevo.setApellidoPaterno(rs.getString("apellido_paterno"));
                 nuevo.setApellidoMaterno(rs.getString("apellido_materno"));
                 nuevo.setCorreoElectronico(rs.getString("correo"));
                 nuevo.setCelular(rs.getString("celular"));
                 nuevo.setFilial(rs.getString("filial"));
                 nuevo.setSis(rs.getString("sis"));
                 nuevo.setRut(Integer.parseInt(rs.getString("rut")));
                 nuevo.setDigitoVerificador(rs.getString("dv").charAt(0));
                 nuevo.setCategoria(rs.getString("categoria"));
                 //no se guardara la fecha de ingreso del socio ni el estado
                 
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
      
      public String buscarCategoria(int rut){
          String sentencia = "SELECT categoria FROM tbl_socio WHERE rut = ?";
          ResultSet rs;
          String categoria;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setInt(1, rut);
              rs = ps.executeQuery();
              
              if(rs.next()){
                  System.out.println("Se ha encontrado la categoria");
                  categoria = rs.getString(1);
                  System.out.println(categoria);
                  return categoria;
              }else{
                  System.out.println("No coincide con ningún regitro");
                  return "";
              }
          }catch(SQLException e){
              System.out.println("No se pudo verificar");
          }
          return "";
      }
      
      public boolean modificar(Socio nuevo){
          String sentencia = "UPDATE tbl_socio SET rut=?,  categoria=?,  dv=?,  nombres=?,  apellido_paterno=?," +
			  "apellido_materno=?,  correo=?,  celular=?, sis=?,  filial=? where rut=?";
			  
          
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setInt(1, nuevo.getRut());
              ps.setString(2, nuevo.getCategoria());
              ps.setString(3, String.valueOf(nuevo.getDigitoVerificador()));
              ps.setString(4, nuevo.getNombres());
              ps.setString(5, nuevo.getApellidoPaterno());
              ps.setString(6, nuevo.getApellidoMaterno());
              ps.setString(7, nuevo.getCorreoElectronico());
              ps.setString(8, nuevo.getCelular());
              ps.setString(9, nuevo.getSis());
              ps.setString(10, nuevo.getFilial());
              ps.setInt(11, nuevo.getRut());
              ps.execute(); //Revisar si no es mejor un executeUpdate
              return true;
          }catch (SQLException e){
              System.out.println("No se pudo modificar");
          }
          
          return false;
      }
      
      public ArrayList<Socio> listSocio(int rut){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial FROM tbl_socio where rut=?"; 
          ArrayList listaSocioP = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setInt(1, rut);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  listaSocioP.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaSocioP;
      }
      
      public ArrayList<Socio> listSis(String sis){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial, sis FROM tbl_socio where sis=?"; 
          ArrayList listaSisP = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, sis);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  socio.setSis(rs.getString(8));
                  listaSisP.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaSisP;
      }
      
      public ArrayList<Socio> listFilial(String filial){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial, sis FROM tbl_socio where filial=?"; 
          ArrayList listaFilialP = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, filial);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  socio.setSis(rs.getString(8));
                  listaFilialP.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaFilialP;
      }
      
      public ArrayList<Socio> listCategoria(String categoria){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial, sis FROM tbl_socio where categoria=?"; 
          ArrayList listaCategoriaP = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, categoria);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  socio.setSis(rs.getString(8));
                  listaCategoriaP.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaCategoriaP;
      }
      
      public ArrayList<Socio> listSiFi(String sis, String filial){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial, sis FROM tbl_socio where sis=? AND filial=?"; 
          ArrayList listaSiFi = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, sis);
              ps.setString(2, filial);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  socio.setSis(rs.getString(8));
                  listaSiFi.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaSiFi;
      }
      
      public ArrayList<Socio> listCaFi(String categoria, String filial){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial, sis FROM tbl_socio where categoria=? AND filial=?"; 
          ArrayList listaCaFi = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, categoria);
              ps.setString(2, filial);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  socio.setSis(rs.getString(8));
                  listaCaFi.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaCaFi;
      }
      
      public ArrayList<Socio> listCaSis(String categoria, String sis){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial, sis FROM tbl_socio where categoria=? AND sis=?"; 
          ArrayList listaCaSis = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, categoria);
              ps.setString(2, sis);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  socio.setSis(rs.getString(8));
                  listaCaSis.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaCaSis;
      }
      
      public ArrayList<Socio> listTodo(String categoria, String sis, String filial){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial, sis FROM tbl_socio where categoria=? AND sis=? AND filial=?"; 
          ArrayList listaTodo = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, categoria);
              ps.setString(2, sis);
              ps.setString(3, filial);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  socio.setSis(rs.getString(8));
                  listaTodo.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaTodo;
      }
      
      public ArrayList<Socio> listUniversidad(String universidad){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial\n" +
                             "FROM tbl_socio\n" +
                             "JOIN tbl_universidad\n" +
                             "ON tbl_socio.rut=tbl_universidad.codigo_ingreso\n" +
                             "where nombre_universidad =?";
          
          ArrayList listaUni = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, universidad);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  listaUni.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          return listaUni;
      }
      
      public ArrayList<Socio> listAlDia(int numeroMes, int anio){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial\n" +
                             "FROM tbl_socio\n" +
                             "JOIN tbl_cuota_social\n" +
                             "on tbl_socio.rut=tbl_cuota_social.tbl_socio_rut\n" +
                             "where YEAR(fecha_pago)=?\n" +
                             "group by tbl_socio_rut\n" +
                             "Having count(tbl_socio_rut)>=?;";
          
          ArrayList listaAlDia = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setInt(1, anio);
              ps.setInt(2, numeroMes);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  listaAlDia.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          
          String sentenciaDos ="SELECT nombres, apellido_paterno, apellido_materno, rut, dv, categoria, filial\n"+
                               "FROM tbl_socio Where categoria = \"Activo/Director\" OR categoria =\"Honorario/Director\" OR categoria =\"Honorario\"";
          
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentenciaDos);
              rs= ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setRut(rs.getInt(4));
                  socio.setDigitoVerificador(rs.getString(5).charAt(0));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  listaAlDia.add(socio);
              }
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
          }
          
          return listaAlDia;
      }
      
      
     public ArrayList<Socio> listCuotasTres(String categoria, String filial, int anio,  int condicion){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, correo, celular, categoria, filial\n" +
                                "FROM tbl_socio\n" +
                                "WHERE categoria=? AND filial=? AND rut NOT IN (SELECT tbl_socio_rut\n" +
                                "FROM tbl_cuota_social\n" +
                                "where YEAR(fecha_pago)=?\n" +
                                "group by tbl_socio_rut\n" +
                                "Having count(tbl_socio_rut)>=?)";
          
          ArrayList listaCuotaTres = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setString(1, categoria);
              ps.setString(2, filial);
              ps.setInt(3, anio);
              ps.setInt(4, condicion);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setCorreoElectronico(rs.getString(4));
                  socio.setCelular(rs.getString(5));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  listaCuotaTres.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
              System.out.println ("El error es: " + e.getMessage());
              e.printStackTrace();
          }
          return listaCuotaTres;
      } 
     
     public ArrayList<Socio> listCuotasTresDos(String categoria, String filial, int anio,  int condicion){
          String sentencia = "SELECT nombres, apellido_paterno, apellido_materno, correo, celular, categoria, filial\n" +
                                "FROM tbl_socio socio\n" +
                                "JOIN (SELECT tbl_socio_rut\n" +
                                "FROM tbl_cuota_social\n" +
                                "where YEAR(fecha_pago)=? \n" +
                                "group by tbl_socio_rut\n" +
                                "Having count(tbl_socio_rut)=?) AS cuotas\n" +
                                "on socio.rut=cuotas.tbl_socio_rut\n" +
                                "WHERE categoria=? AND filial=?";
          
          ArrayList listaCuotaTresDos = new ArrayList();
          Socio socio;
          ResultSet rs;
          try{
              PreparedStatement ps = Conexion.obtenerInstancia().prepareCall(sentencia);
              ps.setInt(1, anio);
              ps.setInt(2, condicion);
              ps.setString(3, categoria);
              ps.setString(4, filial);
              rs = ps.executeQuery();
              while(rs.next()){
                  socio = new Socio();
                  socio.setNombres(rs.getString(1));
                  socio.setApellidoPaterno(rs.getString(2));
                  socio.setApellidoMaterno(rs.getString(3));
                  socio.setCorreoElectronico(rs.getString(4));
                  socio.setCelular(rs.getString(5));
                  socio.setCategoria(rs.getString(6));
                  socio.setFilial(rs.getString(7));
                  listaCuotaTresDos.add(socio);
              }
              
          }catch (SQLException e){
              System.out.println("No se puedo obtener los datos");
              System.out.println ("El error es: " + e.getMessage());
              e.printStackTrace();
          }
          return listaCuotaTresDos;
      } 
}
