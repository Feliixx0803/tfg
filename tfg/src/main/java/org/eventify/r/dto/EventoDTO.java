package org.mnotario.angular.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.mnotario.angular.model.Evento;

public class EventoDTO implements Serializable{
	
	private Long id;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String descripcion;
	private String ubicacion;
	
	public EventoDTO() {
		
	}

	public EventoDTO(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String descripcion,
			String ubicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
	}
	
	public EventoDTO(Evento evento) {
		this.id = evento.getId();
		this.nombre = evento.getNombre();
		this.fechaInicio = evento.getFechaInicio();
		this.fechaFin = evento.getFechaFin();
		this.descripcion = evento.getDescripcion();
		this.ubicacion = evento.getUbicacion();
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
