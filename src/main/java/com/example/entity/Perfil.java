package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Perfil {

	@Id
	private String perfil1;
	private String perfil;



	public String getPerfil1() {
		return perfil1;
	}

	public void setPerfil1(String perfil1) {
		this.perfil1 = perfil1;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
}
