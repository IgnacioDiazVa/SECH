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
}
