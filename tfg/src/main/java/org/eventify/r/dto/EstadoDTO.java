package org.mnotario.angular.dto;

import java.io.Serializable;
import java.util.Collection;

import org.mnotario.angular.model.Inscripcion;

public class EstadoDTO implements Serializable{

	private Long id;
	private String nombre;
	private Collection <Inscripcion> inscripciones;
	
	public EstadoDTO() {
		
	}

	public EstadoDTO(Long id, String nombre, Collection <Inscripcion> inscripciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.inscripciones = inscripciones;
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

	public Collection<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(Collection<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
}
