package org.mnotario.angular.dto;

import java.io.Serializable;
import java.util.Collection;

import org.mnotario.angular.model.Evento;
import org.mnotario.angular.model.Inscripcion;
import org.mnotario.angular.model.Rol;
import org.mnotario.angular.model.Usuario;

/**
 * Representa un objeto de transferencia de datos (DTO) para Usuario.
 */
public class UsuarioDTO {
	
	/**
	 * Identificador único del usuario.
	 */
	private Long id;
	
	/**
	 * Dirección de correo electrónico del usuario.
	 */
	private String email;
	
	/**
	 * Número de teléfono del usuario.
	 */
	private String telefono;
	
	/**
	 * Contraseña del usuario.
	 */
	private String pwd;
	
	/**
	 * Rol asociado al usuario.
	 */
	private Rol rol;
	
	/**
	 * Colección de inscripciones asociadas al usuario.
	 */
	private Collection<Inscripcion> inscripciones;
	
	/**
	 * Colección de eventos gestionados por el usuario.
	 */
	private Collection<Evento> eventosGestionados;
	
	/**
	 * Constructor por defecto de UsuarioDTO.
	 */
	public UsuarioDTO() {
		
	}
	
	/**
	 * Crea un nuevo objeto UsuarioDTO con los valores proporcionados.
	 * @param id - El ID del usuario.
	 * @param email - El correo electrónico del usuario.
	 * @param telefono - El número de teléfono del usuario.
	 * @param pwd - La contraseña del usuario.
	 * @param rol - El rol del usuario.
	 * @param inscripciones - La colección de inscripciones del usuario.
	 * @param eventosGestionados - La colección de eventos gestionados por el usuario.
	 */
	public UsuarioDTO(Long id, String email, String telefono, String pwd, Rol rol,
			Collection<Inscripcion> inscripciones, Collection<Evento> eventosGestionados) {
		super();
		this.id = id;
		this.email = email;
		this.telefono = telefono;
		this.pwd = pwd;
		this.rol = rol;
		this.inscripciones = inscripciones;
		this.eventosGestionados = eventosGestionados;
	}
	
	/**
	 * Crea un nuevo objeto UsuarioDTO a partir de un objeto Usuario existente.
	 * @param usuario - El objeto Usuario.
	 */
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.telefono = usuario.getTelefono();
		this.pwd = usuario.getPwd();
		this.rol = usuario.getRol();
		this.inscripciones = usuario.getInscripciones();
		this.eventosGestionados = usuario.getEventosGestionados();
	}

	/**
	 * Obtiene el ID del usuario.
	 * @return El ID del usuario.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el ID del usuario.
	 * @param id - El ID del usuario.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el correo electrónico del usuario.
	 * @return El correo electrónico del usuario.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el correo electrónico del usuario.
	 * @param email - El correo electrónico del usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene el número de teléfono del usuario.
	 * @return El número de teléfono del usuario.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el número de teléfono del usuario.
	 * @param telefono - El número de teléfono del usuario.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * @return La contraseña del usuario.
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Establece la contraseña del usuario.
	 * @param pwd - La contraseña del usuario.
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * Obtiene el rol del usuario.
	 * @return El rol del usuario.
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * Establece el rol del usuario.
	 * @param rol - El rol del usuario.
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * Obtiene la colección de inscripciones del usuario.
	 * @return La colección de inscripciones del usuario.
	 */
	public Collection<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	/**
	 * Establece la colección de inscripciones del usuario.
	 * @param inscripciones - La colección de inscripciones del usuario.
	 */
	public void setInscripciones(Collection<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	/**
	 * Obtiene la colección de eventos gestionados por el usuario.
	 * @return La colección de eventos gestionados.
	 */
	public Collection<Evento> getEventosGestionados() {
		return eventosGestionados;
	}

	/**
	 * Establece la colección de eventos gestionados por el usuario.
	 * @param eventosGestionados - La colección de eventos gestionados.
	 */
	public void setEventosGestionados(Collection<Evento> eventosGestionados) {
		this.eventosGestionados = eventosGestionados;
	}
}