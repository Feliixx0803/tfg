package org.mnotario.angular.model;



import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Esta clase representa el modelo de datos para el estado de una inscripción.
 * Un estado puede tener varias inscripciones asociadas.
 */
@Entity
@Table(name="estado")
//@JsonIgnoreProperties({"inscripcion"})
public class Estado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "estado")
	private Collection <Inscripcion> inscripciones;

	/**
	 * Constructor por defecto de la clase Estado.
	 * Inicializa la lista de inscripciones como una lista vacía.
	 */
	public Estado() {
		this.inscripciones = new ArrayList<Inscripcion>();
	}

	/**
	 * Constructor de la clase Estado que recibe el ID y el nombre del estado.
	 * @param id el ID del estado.
	 * @param nombre el nombre del estado.
	 */
	public Estado(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Obtiene el ID del estado.
	 * @return el ID del estado.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el ID del estado.
	 * @param id el ID del estado.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del estado.
	 * @return el nombre del estado.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del estado.
	 * @param nombre el nombre del estado.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la colección de inscripciones asociadas al estado.
	 * @return la colección de inscripciones.
	 */
	public Collection<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	/**
	 * Establece la colección de inscripciones asociadas al estado.
	 * @param inscripciones la colección de inscripciones.
	 */
	public void setInscripciones(Collection<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	
}
