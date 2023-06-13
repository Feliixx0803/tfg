package org.mnotario.angular.model;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonBackReference;
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


/**
 * Clase que representa un evento.
 */
@Entity
@Table(name="evento")
public class Evento{
	
	/**
     * ID del evento.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	/**
     * Nombre del evento.
     */
	@Column(unique = true)
	private String nombre;
	
	/**
     * Fecha de inicio del evento.
     */
	@Column(name="fecha_inicio")
	private LocalDate fechaInicio;
	
	/**
     * Fecha de fin del evento.
     */
	@Column(name="fecha_fin")
	private LocalDate fechaFin;
	
	/**
     * Descripción del evento.
     */
	@Column(name="descripcion")
	private String descripcion;
	
	/**
     * Ubicación del evento.
     */
	@Column(name="ubicacion")
	private String ubicacion;
	
	/**
     * Colección de inscripciones asociadas al evento.
     */
	@OneToMany(mappedBy = "evento")
	private Collection<Inscripcion> inscripciones;
	
	/**
     * Usuario gestor del evento.
     */
	@ManyToOne
	private Usuario gestor;
	
	/**
     * Constructor de la clase Evento.
     */
	public Evento() {
		this.inscripciones=new ArrayList<Inscripcion>();
	}
	
	/**
	 * Crea un nuevo objeto Evento con los valores proporcionados.
	 * @param id - El ID del evento.
	 * @param nombre - El nombre del evento.
	 * @param fechaInicio - La fecha de inicio del evento.
	 * @param fechaFin - La fecha de fin del evento.
	 * @param descripcion - La descripción del evento.
	 * @param ubicacion - La ubicación del evento.
	 */
	public Evento(Long id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String descripcion, String ubicacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		//this.imagen = imagen;
		this.ubicacion = ubicacion;
	}

	/**
	 * Obtiene el ID del evento.
	 * @return El ID del evento.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Establece el ID del evento.
	 * @param id - El ID del evento.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del evento.
	 * @return El nombre del evento.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del evento.
	 * @param nombre - El nombre del evento.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la fecha de inicio del evento.
	 * @return La fecha de inicio del evento.
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece la fecha de inicio del evento.
	 * @param fechaInicio - La fecha de inicio del evento.
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene la fecha de fin del evento.
	 * @return La fecha de fin del evento.
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece la fecha de fin del evento.
	 * @param fechaFin - La fecha de fin del evento.
	 */
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene la descripción del evento.
	 * @return La descripción del evento.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del evento.
	 * @param descripcion - La descripción del evento.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la colección de inscripciones del evento.
	 * @return La colección de inscripciones del evento.
	 */
	public Collection<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	/**
	 * Establece la colección de inscripciones del evento.
	 * @param inscripciones - La colección de inscripciones del evento.
	 */
	public void setInscripciones(Collection<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	/**
	 * Obtiene el gestor del evento.
	 * @return El gestor del evento.
	 */
	public Usuario getGestor() {
		return gestor;
	}

	/**
	 * Establece el gestor del evento.
	 * @param gestor - El gestor del evento.
	 */
	public void setGestor(Usuario gestor) {
		this.gestor = gestor;
	}

	/**
	 * Obtiene la ubicación del evento.
	 * @return La ubicación del evento.
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * Establece la ubicación del evento.
	 * @param ubicacion - La ubicación del evento.
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
