package com.example.application.data.entity;
import java.util.Date;

public class RecibosDomiciliados {
	private Integer id;
	private String sConcepto;
	private Date dFechaDomiciliacion;
	private Float fCantidad;
	private CuentaBancaria sCuenta;
	
	public Integer getId() {
		return id;
	}
	/*public void setId(Integer id) {
		this.id = id;
	}*/
	public String getsConcepto() {
		return sConcepto;
	}
	public void setsConcepto(String sConcepto) {
		if(sConcepto == null) throw new IllegalArgumentException("El campo concepto no puede estar vacío.");
		else this.sConcepto = sConcepto;
	}
	public Date getdFechaDomiciliacion() {
		return dFechaDomiciliacion;
	}
	public void setdFechaDomiciliacion(Date dFechaDomiciliacion) {
		this.dFechaDomiciliacion = dFechaDomiciliacion;
	}
	public Float getfCantidad() {
		return fCantidad;
	}
	public void setfCantidad(Float fCantidad) {
		this.fCantidad = fCantidad;
	}
	public CuentaBancaria getsCuenta() {
		return sCuenta;
	}
	public void setsCuenta(CuentaBancaria sCuenta) {
		if(sCuenta == null) throw new IllegalArgumentException("El campo cuenta no puede estar vacío.");
		else this.sCuenta = sCuenta;
	}
	
	public RecibosDomiciliados(Date dFechaDomiciliacion, String sConcepto, Float fCantidad, CuentaBancaria cuenta){ this(null, dFechaDomiciliacion, sConcepto, fCantidad, cuenta); }
	
	private RecibosDomiciliados(Integer iId, Date dFechaDomiciliacion, String sConcepto, Float fCantidad, CuentaBancaria cuenta){
		setsConcepto(sConcepto);
		setdFechaDomiciliacion(dFechaDomiciliacion);
		setfCantidad(fCantidad);
		setsCuenta(cuenta);
		id = iId;
	}
	
}
