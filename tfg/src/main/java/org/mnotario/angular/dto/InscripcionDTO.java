package org.mnotario.angular.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.mnotario.angular.model.Estado;
import org.mnotario.angular.model.Evento;
import org.mnotario.angular.model.Usuario;

/**
 * Clase que representa una inscripción a un evento.
 */
public class InscripcionDTO implements Serializable {
	
	/**
	 * Identificador único de la inscripción.
	 */
	private Long id;
	
	/**
	 * Fecha de la inscripción.
	 */
	private Date fecha;
	
	/**
	 * Estado de la inscripción.
	 */
	private Estado estado;
	
	/**
	 * Usuario asociado a la inscripción.
	 */
	private Usuario usuario;
	
	/**
	 * Evento asociado a la inscripción.
	 */
	private Evento evento;
	
	/**
	 * Constructor por defecto de InscripcionDTO.
	 */
	public InscripcionDTO() {
		super();
	}
	
	/**
	 * Crea un nuevo objeto InscripcionDTO con los valores proporcionados.
	 * @param id - El ID de la inscripción.
	 * @param fecha - La fecha de la inscripción.
	 * @param estado - El estado de la inscripción.
	 * @param usuario - El usuario que realizó la inscripción.
	 * @param evento - El evento al que se realizó la inscripción.
	 */
	public InscripcionDTO(Long id, Date fecha, Estado estado, Usuario usuario, Evento evento) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.usuario = usuario;
		this.evento = evento;
	}
	
	/**
	 * Obtiene la fecha de la inscripción.
	 * @return La fecha de la inscripción.
	 */
	public Date getFecha() {
		return fecha;
	}
	
	/**
	 * Establece la fecha de la inscripción.
	 * @param fecha - La fecha de la inscripción.
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene el estado de la inscripción.
	 * @return El estado de la inscripción.
	 */
	public Estado getEstado() {
		return estado;
	}
	
	/**
	 * Establece el estado de la inscripción.
	 * @param estado - El estado de la inscripción.
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	/**
	 * Obtiene el usuario que realizó la inscripción.
	 * @return El usuario que realizó la inscripción.
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Establece el usuario que realizó la inscripción.
	 * @param usuario - El usuario que realizó la inscripción.
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Obtiene el evento al que se realizó la inscripción.
	 * @return El evento al que se realizó la inscripción.
	 */
	public Evento getEvento() {
		return evento;
	}
	
	/**
	 * Establece el evento al que se realizó la inscripción.
	 * @param evento - El evento al que se realizó la inscripción.
	 */
	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	/**
	 * Obtiene el ID de la inscripción.
	 * @return El ID de la inscripción.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el ID de la inscripción.
	 * @param id - El ID de la inscripción.
	 */
	public void setId(Long id) {
		this.id = id;
	}

}