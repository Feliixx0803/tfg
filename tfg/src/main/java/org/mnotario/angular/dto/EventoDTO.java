package org.mnotario.angular.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.mnotario.angular.model.Evento;

/**
 * Clase que representa los datos de un evento.
 */
public class EventoDTO implements Serializable {
	
	/**
	 * Identificador único del evento.
	 */
	private Long id;
	
	/**
	 * Nombre del evento.
	 */
	private String nombre;
	
	/**
	 * Fecha de inicio del evento.
	 */
	private LocalDate fechaInicio;
	
	/**
	 * Fecha de fin del evento.
	 */
	private LocalDate fechaFin;
	
	/**
	 * Descripción del evento.
	 */
	private String descripcion;
	
	/**
	 * Ubicación del evento.
	 */
	private String ubicacion;
	
	/**
	 * Constructor por defecto de EventoDTO.
	 */
	public EventoDTO() {
		
	}

	/**
	 * Crea un nuevo objeto EventoDTO con los valores proporcionados.
	 * @param id - El ID del evento.
	 * @param nombre - El nombre del evento.
	 * @param fechaInicio - La fecha de inicio del evento.
	 * @param fechaFin - La fecha de fin del evento.
	 * @param descripcion - La descripción del evento.
	 * @param ubicacion - La ubicación del evento.
	 */
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
	
	/**
	 * Crea un nuevo objeto EventoDTO a partir de un objeto Evento.
	 * @param evento - El objeto Evento.
	 */
	public EventoDTO(Evento evento) {
		this.id = evento.getId();
		this.nombre = evento.getNombre();
		this.fechaInicio = evento.getFechaInicio();
		this.fechaFin = evento.getFechaFin();
		this.descripcion = evento.getDescripcion();
		this.ubicacion = evento.getUbicacion();
	}

	/**
	 * Obtiene el ID del evento.
	 * @return El ID del evento.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el ID del evento.
	 * @param id - El ID del evento.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del evento.
	 * @return El nombre del evento.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del evento.
	 * @param nombre - El nombre del evento.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la fecha de inicio del evento.
	 * @return La fecha de inicio del evento.
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece la fecha de inicio del evento.
	 * @param fechaInicio - La fecha de inicio del evento.
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene la fecha de fin del evento.
	 * @return La fecha de fin del evento.
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece la fecha de fin del evento.
	 * @param fechaFin - La fecha de fin del evento.
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene la descripción del evento.
	 * @return La descripción del evento.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del evento.
	 * @param descripcion - La descripción del evento.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la ubicación del evento.
	 * @return La ubicación del evento.
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * Establece la ubicación del evento.
	 * @param ubicacion - La ubicación del evento.
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}