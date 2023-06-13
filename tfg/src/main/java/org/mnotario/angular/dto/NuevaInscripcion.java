package org.mnotario.angular.dto;

import java.util.Date;

/**
 * Clase que representa una nueva inscripción a un evento.
 */
public class NuevaInscripcion {

	  /**
     * ID del evento al que se va a realizar la inscripción.
     */
    private Long idEvento;
    
    /**
     * ID del usuario que realiza la inscripción.
     */
    private Long idUsuario;
    
    /**
     * ID del estado de la inscripción.
     */
    private Long idEstado;
    
    /**
     * Fecha de la inscripción.
     */
    private Date fecha;
    
    /**
     * Constructor de la clase NuevaInscripcion.
     */
    public NuevaInscripcion() {
        
    }

	/**
	 * Crea un nuevo objeto NuevaInscripcion con los valores proporcionados.
	 * @param idEvento - El ID del evento al que se desea inscribir.
	 * @param idUsuario - El ID del usuario que realiza la inscripción.
	 * @param idEstado - El ID del estado de la inscripción.
	 * @param fecha - La fecha de la inscripción.
	 */
	public NuevaInscripcion(Long idEvento, Long idUsuario, Long idEstado, Date fecha) {
		super();
		this.idEvento = idEvento;
		this.idUsuario = idUsuario;
		this.idEstado = idEstado;
		this.fecha = fecha;
	}

	/**
	 * Obtiene el ID del evento al que se desea inscribir.
	 * @return El ID del evento.
	 */
	public Long getIdEvento() {
		return idEvento;
	}

	/**
	 * Establece el ID del evento al que se desea inscribir.
	 * @param idEvento - El ID del evento.
	 */
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	/**
	 * Obtiene el ID del usuario que realiza la inscripción.
	 * @return El ID del usuario.
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Establece el ID del usuario que realiza la inscripción.
	 * @param idUsuario - El ID del usuario.
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtiene el ID del estado de la inscripción.
	 * @return El ID del estado.
	 */
	public Long getIdEstado() {
		return idEstado;
	}

	/**
	 * Establece el ID del estado de la inscripción.
	 * @param idEstado - El ID del estado.
	 */
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
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
	
}
