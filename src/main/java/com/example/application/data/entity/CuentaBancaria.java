package com.example.application.data.entity;
import java.util.Date;

public class CuentaBancaria {

	private Integer id;
	private String iban;
    private User titular; //Como se relaciona con el usuario
    private Float saldo;
    private Date dFechaCreacion;
	
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public User getTitular() {
		return titular;
	}
	public void setTitular(User titular) {
		this.titular = titular;
	}
	
	public Float getSaldo() {
		return saldo;
	}
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	
	public Date getdFechaCreacion() {
		return dFechaCreacion;
	}
	public void setdFechaCreacion(Date dFechaCreacion) {
		this.dFechaCreacion = dFechaCreacion;
	}
    
}
