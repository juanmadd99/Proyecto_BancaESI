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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "movimiento")
public class Movimiento extends AbstractEntity {
	private String concepto;
	private Date dFecha;
	private Float fValor;
	private String cuentao; //Darle valor correspondiente con el constructor Cuenta->getIBAN();
	private String cuentad;	//Darle valor correspondiente con el constructor Cuenta->getIBAN();
	
	
	@ManyToOne
    @JoinColumn(name="cuenta_origen")
    private Cuenta cuenta_origen;
	@ManyToOne
	@JoinColumn(name = "cuenta_destino")
	private Cuenta cuenta_destino; //Si recibes dinero, tu cuenta es la destino.
	
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
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
	public String getCuentao() {
		return cuentao;
	}
	public void setCuentao(String cuentao) {
		this.cuentao = cuentao;
	}
	public String getCuentad() {
		return cuentad;
	}
	public void setCuentad(String cuentad) {
		this.cuentad = cuentad;
	}
	
	
	public Cuenta getCuenta_origen() {
		return cuenta_origen;
	}
	public void setCuenta_origen(Cuenta cuenta_origen) {
		this.cuenta_origen = cuenta_origen;
	}
	public Cuenta getCuenta_destino() {
		return cuenta_destino;
	}
	public void setCuenta_destino(Cuenta cuenta_destino) {
		this.cuenta_destino = cuenta_destino;
	}
	
	
	/*
	public Movimiento(String concepto, Date dFecha, Float fValor, String cuentao, String cuentad, Cuenta cuenta_origen,
			Cuenta cuenta_destino) {
		super();
		this.concepto = concepto;
		this.dFecha = dFecha;
		this.fValor = fValor;
		this.cuentao = cuentao;
		this.cuentad = cuentad;
		this.cuenta_origen = cuenta_origen;
		this.cuenta_destino = cuenta_destino;
	}
	*/
}
