package org.mnotario.angular.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String nombre;
	private String email;
	private String telefono;

	@ManyToOne
	private Rol rol;

	@OneToMany(mappedBy = "usuario")
	private Collection<Inscripcion> inscripcion;

	public Usuario() {
		this.inscripcion=new ArrayList<Inscripcion>();
	}

	public Usuario(Long id, String nombre, String email, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
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

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public Collection<Inscripcion> getinscripcion() {
		return inscripcion;
	}

	public void setinscripcion(Collection<Inscripcion> inscripcion) {
		this.inscripcion = inscripcion;
	}

	@Override
	public String toString() {
		return "Usuario{" + "id=" + id + '\'' + "nombre=" + nombre + '\'' + "email=" + email + '\'' + "telefono="
				+ telefono + '\'' + "}";
	}
}
