package org.mnotario.angular.dto;

/**
 * Clase que representa los datos de un evento.
 */
public class DatosEvento {
	
	/**
	 * Nombre del evento
	 */
	private String nombre;
	
	/**
	 * Numero de usuarios inscritos al evento
	 */
	private int usuariosInscritos;
	
	/**
     * Constructor sin argumentos de la clase DatosEvento.
     * Se utiliza para crear una instancia vacía de la clase.
     */
	public DatosEvento() {
		
	}

	  /**
     * Constructor de la clase DatosEvento que recibe el nombre y la cantidad de usuarios inscritos.
     *
     * @param nombre            el nombre del evento
     * @param usuariosInscritos la cantidad de usuarios inscritos al evento
     */
	public DatosEvento(String nombre, int usuariosInscritos) {
		super();
		this.nombre = nombre;
		this.usuariosInscritos = usuariosInscritos;
	}

	/**
     * Obtiene el nombre del evento.
     *
     * @return el nombre del evento
     */
	public String getNombre() {
		return nombre;
	}

	/**
     * Establece el nombre del evento.
     *
     * @param nombre el nombre del evento
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 /**
	 * Obtiene la cantidad de usuarios inscritos al evento.
	 *
	 * @return la cantidad de usuarios inscritos al evento
	 */
	public int getUsuariosInscritos() {
		return usuariosInscritos;
	}

	 /**
     * Establece la cantidad de usuarios inscritos al evento.
     *
     * @param usuariosInscritos la cantidad de usuarios inscritos al evento
     */
	public void setUsuariosInscritos(int usuariosInscritos) {
		this.usuariosInscritos = usuariosInscritos;
	}

}
