package org.mnotario.angular.model;

public class RegisterDTO {

	private String nombre;
	private String email;
	private String telefono;
	private String pwd;
	
	public RegisterDTO(String nombre, String email, String telefono, String pwd) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.pwd = pwd;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
