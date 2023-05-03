package org.mnotario.angular.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Inscripcion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private LocalDate fecha;
	
	@OneToMany(mappedBy = "inscripcionUsuarios")
	private Collection<Usuario> usuarios;

	@OneToMany(mappedBy = "inscripcionEventos")
	private Collection<Evento> eventos;
	
	public Inscripcion() {
		this.usuarios = new ArrayList<Usuario>();
		this.eventos = new ArrayList<Evento>();

	}

	public Inscripcion(Long id, LocalDate fecha) {
		super();
		this.id = id;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Collection<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
	
	
}
