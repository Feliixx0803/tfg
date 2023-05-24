package org.mnotario.angular.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
@JsonIgnoreProperties({"inscripciones"})
public class Usuario implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String nombre;
	private String email;
	private String telefono;
	private String pwd;

	@ManyToOne
	private Rol rol;

	@OneToMany(mappedBy = "usuario")
	private Collection<Inscripcion> inscripciones;
	
	
	@OneToMany(mappedBy = "gestor")
	@JsonManagedReference
	private Collection<Evento> eventosGestionados;

	public Usuario() {
		this.inscripciones=new ArrayList<Inscripcion>();
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

	public Collection<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(Collection<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Collection<Evento> getEventosGestionados() {
		return eventosGestionados;
	}

	public void setEventosGestionados(Collection<Evento> eventosGestionados) {
		this.eventosGestionados = eventosGestionados;
	}
}
