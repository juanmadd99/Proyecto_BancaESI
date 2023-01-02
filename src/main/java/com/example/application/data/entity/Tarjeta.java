package com.example.application.data.entity;
import java.util.Date;

public class Tarjeta {
	private Integer id;
	private Integer numero;
	private String emisor; //Visa, MasterCard y American Express.
	private CuentaBancaria cuenta;
	private Date fechaCaducidad;
	private Integer pin;
	private Integer cvv;
	private Float limiteMax;
	private Float limiteMin;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public CuentaBancaria getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	public Float getLimiteMax() {
		return limiteMax;
	}
	public void setLimiteMax(Float limiteMax) {
		this.limiteMax = limiteMax;
	}
	public Float getLimiteMin() {
		return limiteMin;
	}
	public void setLimiteMin(Float limiteMin) {
		this.limiteMin = limiteMin;
	}
	
}
