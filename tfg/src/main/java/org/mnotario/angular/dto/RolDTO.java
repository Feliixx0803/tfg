package org.mnotario.angular.dto;

import java.io.Serializable;
import java.util.Collection;

import org.mnotario.angular.model.Usuario;

/**
 * Clase que representa un rol de usuario.
 */
public class RolDTO implements Serializable{

	/**
	 * Identificador único del rol.
	 */
	private Long id;
	
	/**
	 * Nombre del rol.
	 */
	private String nombre;
	
	/**
	 * Colección de usuarios asociados al rol.
	 */
	private Collection<Usuario> usuarios;
	
	/**
	 * Constructor por defecto de RolDTO.
	 */
	public RolDTO() {
		
	}


	/**
	 * Crea un nuevo objeto RolDTO con los valores proporcionados.
	 * @param id - El ID del rol.
	 * @param nombre - El nombre del rol.
	 * @param usuarios - La colección de usuarios asociados al rol.
	 */
	public RolDTO(Long id, String nombre, Collection<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	/**
	 * Obtiene el ID del rol.
	 * @return El ID del rol.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el ID del rol.
	 * @param id - El ID del rol.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del rol.
	 * @return El nombre del rol.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del rol.
	 * @param nombre - El nombre del rol.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la colección de usuarios asociados al rol.
	 * @return La colección de usuarios.
	 */
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Establece la colección de usuarios asociados al rol.
	 * @param usuarios - La colección de usuarios.
	 */
	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
		
}