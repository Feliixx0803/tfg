package org.mnotario.angular.dto;

import java.io.Serializable;
import java.util.Collection;

import org.mnotario.angular.model.Evento;
import org.mnotario.angular.model.Inscripcion;
import org.mnotario.angular.model.Rol;
import org.mnotario.angular.model.Usuario;

public class UsuarioDTO implements Serializable{

	private Long id;
	private String email;
	private String telefono;
	private String pwd;
	private Rol rol;
	private Collection<Inscripcion> inscripciones;
	private Collection<Evento> eventosGestionados;
	
	public UsuarioDTO(){
		
	}

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
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.telefono = usuario.getTelefono();
		this.pwd = usuario.getPwd();
		this.rol = usuario.getRol();
		this.inscripciones = usuario.getInscripciones();
		this.eventosGestionados = usuario.getEventosGestionados();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Collection<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(Collection<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public Collection<Evento> getEventosGestionados() {
		return eventosGestionados;
	}

	public void setEventosGestionados(Collection<Evento> eventosGestionados) {
		this.eventosGestionados = eventosGestionados;
	}
}
