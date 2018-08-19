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
public class CambioCategoria {
        private Integer rutCambio;
	private String transicion;
	private Date fechaCambio;
	
	//Atributos con claves foráneas en la base de datos
	private String categoriaCambio;
	
	//Constructores
	public CambioCategoria() {
		
	}

	public CambioCategoria(Integer rutCambio, String transicion, Date fechaCambio) {
		super();
		this.rutCambio = rutCambio;
		this.transicion = transicion;
		this.fechaCambio = fechaCambio;
	}

	public CambioCategoria(String transicion, Date fechaCambio) {
		super();
		this.transicion = transicion;
		this.fechaCambio = fechaCambio;
	}

	public CambioCategoria(Integer rutCambio, String transicion, Date fechaCambio, String categoriaCambio) {
		super();
		this.rutCambio = rutCambio;
		this.transicion = transicion;
		this.fechaCambio = fechaCambio;
		this.categoriaCambio = categoriaCambio;
	}

	//Getters y Setters
	public Integer getRutCambio() {
		return rutCambio;
	}

	public void setRutCambio(Integer rutCambio) {
		this.rutCambio = rutCambio;
	}

	public String getTransicion() {
		return transicion;
	}

	public void setTransicion(String transicion) {
		this.transicion = transicion;
	}

	public Date getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public String getCategoriaCambio() {
		return categoriaCambio;
	}

	public void setCategoriaCambio(String categoriaCambio) {
		this.categoriaCambio = categoriaCambio;
	}
}
