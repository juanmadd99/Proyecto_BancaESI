package com.example.application.data.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recibosDomiciliados")
public class RecibosDomiciliados extends AbstractEntity {
	
	private String concepto;
	private Date fecha;
	private Float valor;
	
	@ManyToOne
	@JoinColumn(name = "cuenta_id")
	private Cuenta cuenta;
	
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}	
}
