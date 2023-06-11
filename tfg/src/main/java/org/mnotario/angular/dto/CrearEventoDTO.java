package org.mnotario.angular.dto;

import java.time.LocalDate;

public class CrearEventoDTO {

	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String descripcion;
	private String ubicacion;
	private Long idGestor;
	
	public CrearEventoDTO() {
		
	}

	public CrearEventoDTO(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String descripcion,
			String ubicacion, Long idGestor) {
		super();
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
		this.idGestor = idGestor;
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

	public Long getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(Long idGestor) {
		this.idGestor = idGestor;
	}
	
	
}
