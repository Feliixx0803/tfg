package org.mnotario.angular.dto;

public class DatosEvento {
	
	private String nombre;
	private int usuariosInscritos;
	
	public DatosEvento() {
		
	}

	public DatosEvento(String nombre, int usuariosInscritos) {
		super();
		this.nombre = nombre;
		this.usuariosInscritos = usuariosInscritos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUsuariosInscritos() {
		return usuariosInscritos;
	}

	public void setUsuariosInscritos(int usuariosInscritos) {
		this.usuariosInscritos = usuariosInscritos;
	}

}
