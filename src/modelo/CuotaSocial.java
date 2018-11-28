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
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class CuotaSocial {
        private Date fechaPago;
	private Integer monto;
	private String formaPago;
	
	//Atributos con claves foráneas en la base de datos
	private Integer cuotaRut;
	private String cuotaCategoria;
        
        private int aux;
        
        public CuotaSocial(){
            
        }

    public CuotaSocial(Date fechaPago, Integer monto, String formaPago, Integer cuotaRut, String cuotaCategoria) {
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.formaPago = formaPago;
        this.cuotaRut = cuotaRut;
        this.cuotaCategoria = cuotaCategoria;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Integer getCuotaRut() {
        return cuotaRut;
    }

    public void setCuotaRut(Integer cuotaRut) {
        this.cuotaRut = cuotaRut;
    }

    public String getCuotaCategoria() {
        return cuotaCategoria;
    }

    public void setCuotaCategoria(String cuotaCategoria) {
        this.cuotaCategoria = cuotaCategoria;
    }
        
    public boolean agregar(CuotaSocial nuevo){
          String sentencia = "INSERT INTO tbl_cuota_social (fecha_pago,  monto,  forma_pago,  tbl_socio_rut,  tbl_socio_categoria)" +
			  "VALUES(?,?,?,?,?)";
          
          try{
              if(!buscar((nuevo.getCuotaRut()),(nuevo.getFechaPago()))){
              PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
              ps.setDate(1, nuevo.getFechaPago());
              ps.setInt(2, nuevo.getMonto());
              ps.setString(3, nuevo.getFormaPago());
              ps.setInt(4, nuevo.getCuotaRut());
              ps.setString(5, nuevo.getCuotaCategoria());
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
    
    public boolean buscar(int rut, Date pago){
         String sentencia = "SELECT * FROM tbl_cuota_social WHERE tbl_socio_rut = ? AND fecha_pago = ?";
         ResultSet rs;
         try{
             PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
             ps.setInt(1, rut);
             ps.setDate(2, pago);
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
    
    public int buscar(int rut, int anio){
         String sentencia = "SELECT fecha_pago FROM tbl_cuota_social WHERE tbl_socio_rut = ? AND YEAR(fecha_pago) = ?";
         ResultSet rs;
         ArrayList cuotasSocio = new ArrayList();
         CuotaSocial cuota;
         try{
             PreparedStatement ps = Conexion.obtenerInstancia().prepareStatement(sentencia);
             ps.setInt(1, rut);
             ps.setInt(2, anio);
             rs = ps.executeQuery();
             
             while(rs.next()){
                cuota = new CuotaSocial();
                cuota.setFechaPago(rs.getDate(1));
                cuotasSocio.add(cuota);
             }
         }catch(SQLException e){
             System.out.println("No se pudo verificar");
         }
         
         return cuotasSocio.size();
      }
    
    
}
