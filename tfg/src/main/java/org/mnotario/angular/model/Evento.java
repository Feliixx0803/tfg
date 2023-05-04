package org.mnotario.angular.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
@JsonIgnoreProperties({"inscripciones"})
public class Evento implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String descripcion;
	
	@OneToMany(mappedBy = "evento")
	private Collection<Inscripcion> inscripciones;
	
	public Evento() {
		this.inscripciones=new ArrayList<Inscripcion>();
	}

	public Evento(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(Collection<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	
	
	
	
	

}
