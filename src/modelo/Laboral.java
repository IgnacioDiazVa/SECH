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
public class Laboral {
        private String direccion;
	private Integer piso;
	private String oficina;
	private Integer numeroTelefono;
	private String referencia;
	private String sitioWeb;
	private String nombreLaboral;
	
	//Atributos con claves foráneas en la base de datos
	private Integer laboralRut;
	private String laboralCategoria;
	private Integer codigoComunaLaboral;
	
	//Constructores
	public Laboral() {		
	}
        
        public Laboral(String direccion, Integer numeroTelefono,
			 Integer laboralRut, String laboralCategoria,
			Integer codigoComunaLaboral) {
		super();
		this.direccion = direccion;
		this.numeroTelefono = numeroTelefono;
		this.laboralRut = laboralRut;
		this.laboralCategoria = laboralCategoria;
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
        
        public Laboral(String direccion, Integer piso, Integer numeroTelefono,
			 Integer laboralRut, String laboralCategoria,
			Integer codigoComunaLaboral) {
		super();
		this.direccion = direccion;
                this.piso = piso;
		this.numeroTelefono = numeroTelefono;
		this.laboralRut = laboralRut;
		this.laboralCategoria = laboralCategoria;
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
        
        public Laboral(String direccion, String oficina, Integer numeroTelefono,
			 Integer laboralRut, String laboralCategoria,
			Integer codigoComunaLaboral) {
		super();
		this.direccion = direccion;
                this.oficina = oficina;
		this.numeroTelefono = numeroTelefono;
		this.laboralRut = laboralRut;
		this.laboralCategoria = laboralCategoria;
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
        

	public Laboral(String direccion, Integer piso, String oficina, Integer numeroTelefono, String referencia,
			String sitioWeb, String nombreLaboral) {
		super();
		this.direccion = direccion;
		this.piso = piso;
		this.oficina = oficina;
		this.numeroTelefono = numeroTelefono;
		this.referencia = referencia;
		this.sitioWeb = sitioWeb;
		this.nombreLaboral = nombreLaboral;
	}

	public Laboral(String direccion, Integer piso, String oficina, Integer numeroTelefono, String referencia,
			String sitioWeb, String nombreLaboral, Integer laboralRut, String laboralCategoria,
			Integer codigoComunaLaboral) {
		super();
		this.direccion = direccion;
		this.piso = piso;
		this.oficina = oficina;
		this.numeroTelefono = numeroTelefono;
		this.referencia = referencia;
		this.sitioWeb = sitioWeb;
		this.nombreLaboral = nombreLaboral;
		this.laboralRut = laboralRut;
		this.laboralCategoria = laboralCategoria;
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
	
	//Getters y Setters
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getNombreLaboral() {
		return nombreLaboral;
	}

	public void setNombreLaboral(String nombreLaboral) {
		this.nombreLaboral = nombreLaboral;
	}

	public Integer getLaboralRut() {
		return laboralRut;
	}

	public void setLaboralRut(Integer laboralRut) {
		this.laboralRut = laboralRut;
	}

	public String getLaboralCategoria() {
		return laboralCategoria;
	}

	public void setLaboralCategoria(String laboralCategoria) {
		this.laboralCategoria = laboralCategoria;
	}

	public Integer getCodigoComunaLaboral() {
		return codigoComunaLaboral;
	}

	public void setCodigoComunaLaboral(Integer codigoComunaLaboral) {
		this.codigoComunaLaboral = codigoComunaLaboral;
	}
}
