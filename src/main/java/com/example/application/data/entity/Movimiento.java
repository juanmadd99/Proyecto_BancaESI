package com.example.application.data.entity;
import java.util.Date;

public class Movimiento {
	private Integer id;
	private Date dFecha;
	private Float fValor;
	private CuentaBancaria cuentaOrigen; 
	private CuentaBancaria cuentaDestino; //Si recibes dinero, tu cuenta es la destino.
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	
	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	
}