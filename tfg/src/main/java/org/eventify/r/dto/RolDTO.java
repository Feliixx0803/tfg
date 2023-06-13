package org.mnotario.angular.dto;

import java.io.Serializable;
import java.util.Collection;

import org.mnotario.angular.model.Usuario;

public class RolDTO implements Serializable{

	private Long id;
	private String nombre;
	private Collection<Usuario> usuarios;
	
	public RolDTO() {
		
	}

	public RolDTO(Long id, String nombre, Collection<Usuario> usuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuarios = usuarios;
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

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
