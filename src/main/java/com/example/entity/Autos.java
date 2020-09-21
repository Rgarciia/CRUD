package com.example.entity;

import java.util.Date;

public class Autos {
	private Integer id;
	private String modelo;
	private Date anio;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getAnio() {
		return anio;
	}
	public void setAnio(Date anio) {
		this.anio = anio;
	}
	@Override
	public String toString() {
		return "Autos [id=" + id + ", modelo=" + modelo + ", anio=" + anio + "]";
	}
	
	
}
