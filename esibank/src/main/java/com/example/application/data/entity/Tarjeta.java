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
@Table(name = "tarjeta")
public class Tarjeta extends AbstractEntity {
	
	private Integer numero;
	private String emisor; //Visa, MasterCard y American Express.
	private Integer cuentaBancaria;
	private Date fecha_caducidad;
	private Integer pin;
	private Integer cvv;
	private Float limite_minimo;
	private Float limite_maximo;
	
  
    public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public Integer getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(Integer cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}
	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
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
	public Float getLimite_minimo() {
		return limite_minimo;
	}
	public void setLimite_minimo(Float limite_minimo) {
		this.limite_minimo = limite_minimo;
	}
	public Float getLimite_maximo() {
		return limite_maximo;
	}
	public void setLimite_maximo(Float limite_maximo) {
		this.limite_maximo = limite_maximo;
	}
	
    public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
