/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

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
        
        
}
