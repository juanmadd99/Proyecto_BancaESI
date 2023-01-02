package com.example.application.data.entity;

import java.util.Date;

public class Consulta {
	private Integer id;
	private Date dFechaRealizacion;
	private String sContenido;
	private User gestor;	//Gestor al que se le envia la consulta
	
	public Integer getId() {
		return id;
	}
	/*public void setId(Integer id) {
		this.id = id;
	}*/
	public Date getdFechaRealizacion() {
		return dFechaRealizacion;
	}
	public void setdFechaRealizacion(Date dFechaRealizacion) {
		this.dFechaRealizacion = dFechaRealizacion;
	}
	public String getsContenido() {
		return sContenido;
	}
	public void setsContenido(String sContenido) {
		if(sContenido == null) throw new IllegalArgumentException("El campo contenido no puede estar vacío.");
		else this.sContenido = sContenido;
	}
	public User getGestor() {
		return gestor;
	}
	public void setGestor(User gestor) {
		if(gestor == null) throw new IllegalArgumentException("El campo gestor no puede estar vacío.");
		else this.gestor = gestor;
	}
	
	public Consulta(Date dFechaRealizacion, String sContenido, User gestor){ this(null, dFechaRealizacion, sContenido, gestor); }
	
	private Consulta(Integer iId, Date dFechaRealizacion, String sContenido, User gestor) {
		setdFechaRealizacion(dFechaRealizacion);
		setsContenido(sContenido);
		setGestor(gestor);
		id = iId;
	}

}
