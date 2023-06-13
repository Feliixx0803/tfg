package org.mnotario.angular.dto;

import java.io.Serializable;
import java.util.Collection;

import org.mnotario.angular.model.Inscripcion;

/**
 * Clase que representa el estado de un objeto.
 */
public class EstadoDTO implements Serializable {

    /**
     * Identificador único del estado.
     */
    private Long id;
    
    /**
     * Nombre del estado.
     */
    private String nombre;
    
    /**
     * Colección de inscripciones asociadas al estado.
     */
    private Collection<Inscripcion> inscripciones;
    
    /**
     * Constructor por defecto de EstadoDTO.
     */
    public EstadoDTO() {
        
    }
    /**
     * Crea un nuevo objeto EstadoDTO con los valores proporcionados.
     * @param id - El ID del estado.
     * @param nombre - El nombre del estado.
     * @param inscripciones - La colección de inscripciones asociadas al estado.
     */
    public EstadoDTO(Long id, String nombre, Collection<Inscripcion> inscripciones) {
        this.id = id;
        this.nombre = nombre;
        this.inscripciones = inscripciones;
    }

    /**
     * Obtiene el ID del estado.
     * @return El ID del estado.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del estado.
     * @param id El ID del estado.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estado.
     * @return El nombre del estado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estado.
     * @param nombre El nombre del estado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la colección de inscripciones asociadas al estado.
     * @return La colección de inscripciones.
     */
    public Collection<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    /**
     * Establece la colección de inscripciones asociadas al estado.
     * @param inscripciones La colección de inscripciones.
     */
    public void setInscripciones(Collection<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
}