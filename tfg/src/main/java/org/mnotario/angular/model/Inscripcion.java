package org.mnotario.angular.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


/**
 * Clase que representa una inscripción a un evento.
 */
@Entity
public class Inscripcion implements Serializable {
	/**
	 * Identificador único de la Inscripcion.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	/**
	 * Fecha de la Inscripcion.
	 */
	private Date fecha;
	
	/**
	 * Usuario asociado a la Inscripcion.
	 */
	@ManyToOne
	private Usuario usuario;

	/**
	 * Evento asociado a la Inscripcion.
	 */
	@ManyToOne
	private Evento evento;
	
	/**
	 * Estado asociado a la Inscripcion.
	 */
	@ManyToOne
	private Estado estado;
	
	/**
	 * Constructor por defecto de Inscripcion.
	 */
	public Inscripcion() {
	}

	/**
	 * Crea una nueva inscripción con los valores proporcionados.
	 * @param id - El ID de la inscripción.
	 * @param fecha - La fecha de la inscripción.
	 */
	public Inscripcion(Long id, Date fecha) {
		super();
		this.id = id;
		this.fecha = fecha;
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
	 * Obtiene el usuario asociado a la inscripción.
	 * @return El usuario asociado a la inscripción.
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Establece el usuario asociado a la inscripción.
	 * @param usuario - El usuario asociado a la inscripción.
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene el evento asociado a la inscripción.
	 * @return El evento asociado a la inscripción.
	 */
	public Evento getEvento() {
		return evento;
	}

	/**
	 * Establece el evento asociado a la inscripción.
	 * @param evento - El evento asociado a la inscripción.
	 */
	public void setEvento(Evento evento) {
		this.evento = evento;
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
}