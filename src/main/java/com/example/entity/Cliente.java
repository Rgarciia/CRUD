package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue
	private long id;
	@NotBlank(message = "El nombre no puede ser vacio")
	@Size(min = 0, max = 10, message = "No entra en el rango")
	private String name;
	@Column(nullable = false)
	private Integer edad;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@OneToOne
	@JoinColumn(name = "idG")
	private Grupo grupos;

	public Grupo getGrupos() {
		return grupos;
	}

	public void setGrupos(Grupo grupos) {
		this.grupos = grupos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", name=" + name + ", edad=" + edad + ", fecha=" + fecha + ", grupos=" + grupos
				+ "]";
	}
	

	public Cliente(long id,
			@NotBlank(message = "El nombre no puede ser vacio") @Size(min = 0, max = 10, message = "No entra en el rango") String name,
			Integer edad, Date fecha, Grupo grupos) {
		super();
		this.id = id;
		this.name = name;
		this.edad = edad;
		this.fecha = fecha;
		this.grupos = grupos;
	}

	public Cliente() {

	}

}
