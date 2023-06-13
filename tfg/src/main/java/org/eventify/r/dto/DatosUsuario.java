package org.mnotario.angular.dto;

public class DatosUsuario{

	private String nombre;
	private String email;
	private String telefono;
	private String nombreRol;
	
	public DatosUsuario() {
		
	}

	public DatosUsuario(String nombre, String email, String telefono, String nombreRol) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.nombreRol = nombreRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	
}
