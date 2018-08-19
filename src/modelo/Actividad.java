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
}
