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
public class Region {
        private Integer codigoRegion;
	private String nombre;
	
	//Constructores
	public Region() {
	}
	
	public Region(Integer codigoRegion, String nombre) {
		super();
		this.codigoRegion = codigoRegion;
		this.nombre = nombre;
	}

	//Getters y Setters
	public Integer getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(Integer codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
