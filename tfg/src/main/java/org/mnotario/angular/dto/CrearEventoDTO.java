package org.mnotario.angular.dto;

import java.time.LocalDate;

/**
 * DTO utilizado para crear un nuevo evento.
 * Contiene la información necesaria para crear un evento en el sistema.
 */
public class CrearEventoDTO {

    /**
     * Nombre del evento.
     */
    private String nombre;
    
    /**
     * Fecha de inicio del evento.
     */
    private LocalDate fechaInicio;
    
    /**
     * Fecha de fin del evento.
     */
    private LocalDate fechaFin;
    
    /**
     * Descripción del evento.
     */
    private String descripcion;
    
    /**
     * Ubicación del evento.
     */
    private String ubicacion;
    
    /**
     * Identificador del gestor del evento.
     */
    private Long idGestor;
    
    /**
     * Constructor vacío de la clase CrearEventoDTO.
     */
    public CrearEventoDTO() {
        
    }

    /**
     * Crea un nuevo objeto CrearEventoDTO con los valores proporcionados.
     * @param nombre - El nombre del evento.
     * @param fechaInicio - La fecha de inicio del evento.
     * @param fechaFin - La fecha de fin del evento.
     * @param descripcion - La descripción del evento.
     * @param ubicacion - La ubicación del evento.
     * @param idGestor - El ID del gestor del evento.
     */
    public CrearEventoDTO(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String descripcion,
            String ubicacion, Long idGestor) {
        super();
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.idGestor = idGestor;
    }

    /**
     * Obtiene el nombre del evento.
     * @return String - El nombre del evento.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del evento.
     * @param nombre - El nombre del evento a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de inicio del evento.
     * @return LocalDate - La fecha de inicio del evento.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio del evento.
     * @param fechaInicio - La fecha de inicio del evento a establecer.
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin del evento.
     * @return LocalDate - La fecha de fin del evento.
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin del evento.
     * @param fechaFin - La fecha de fin del evento a establecer.
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene la descripción del evento.
     * @return String - La descripción del evento.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del evento.
     * @param descripcion - La descripción del evento a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la ubicación del evento.
     * @return String - La ubicación del evento.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación del evento.
     * @param ubicacion - La ubicación del evento a establecer.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el ID del gestor del evento.
     * @return Long - El ID del gestor del evento.
     */
    public Long getIdGestor() {
        return idGestor;
    }

    /**
     * Establece el ID del gestor del evento.
     * @param idGestor - El ID del gestor del evento a establecer.
     */
    public void setIdGestor(Long idGestor) {
        this.idGestor = idGestor;
    }
}
