package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "grupos")
public class Grupo {
	@Id
	@GeneratedValue
	private long idG;
	@NotBlank(message = "El nombre no puede ser vacio")
	@Size(min = 0, max = 10, message = "No entra en el rango")
	private String nameG;

	public long getIdG() {
		return idG;
	}

	public void setIdG(long idG) {
		this.idG = idG;
	}

	public String getNameG() {
		return nameG;
	}

	public void setNameG(String nameG) {
		this.nameG = nameG;
	}

	public Grupo(long idG,
			@NotBlank(message = "El nombre no puede ser vacio") @Size(min = 0, max = 10, message = "No entra en el rango") String nameG) {
		super();
		this.idG = idG;
		this.nameG = nameG;
	}
	public Grupo() {
		   
	}
}
