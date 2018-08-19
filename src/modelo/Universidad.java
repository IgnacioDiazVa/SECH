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
}
