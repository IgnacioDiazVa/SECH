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
public class Comuna {
        private Integer codigoComuna;
	private String nombre;
	
	//Atributos con claves foráneas en la base de datos
	private Integer codRegion;
	
	//Constructores
	public Comuna() {
	}

	public Comuna(Integer codigoComuna, String nombre) {
		super();
		this.codigoComuna = codigoComuna;
		this.nombre = nombre;
	}

	public Comuna(Integer codigoComuna, String nombre, Integer codRegion) {
		super();
		this.codigoComuna = codigoComuna;
		this.nombre = nombre;
		this.codRegion = codRegion;
	}

	//Getters y Setters
	public Integer getCodigoComuna() {
		return codigoComuna;
	}

	public void setCodigoComuna(Integer codigoComuna) {
		this.codigoComuna = codigoComuna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodRegion() {
		return codRegion;
	}

	public void setCodRegion(Integer codRegion) {
		this.codRegion = codRegion;
	}
}
