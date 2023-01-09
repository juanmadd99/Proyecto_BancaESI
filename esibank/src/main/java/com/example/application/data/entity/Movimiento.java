package com.example.application.data.entity;

import com.example.application.data.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")
public class Movimiento extends AbstractEntity {
	
	private Date dFecha;
	private Float fValor;
	private String cuentaOrigen;
	private String cuentaDestino;
	
	public Date getdFecha() {
		return dFecha;
	}
	public void setdFecha(Date dFecha) {
		this.dFecha = dFecha;
	}
	public Float getfValor() {
		return fValor;
	}
	public void setfValor(Float fValor) {
		this.fValor = fValor;
	}
	public String getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(String cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	public String getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(String cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	
}
