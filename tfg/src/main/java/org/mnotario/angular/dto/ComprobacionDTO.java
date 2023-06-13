package org.mnotario.angular.dto;

/**
 * La clase ComprobacionDTO es un DTO (Objeto de Transferencia de Datos) que representa la información necesaria para realizar una comprobación de evento y usuario.
 *
 */
public class ComprobacionDTO {

    /**
     * Identificador del evento.
     */
    private long idEvento;
    
    /**
     * Identificador del usuario.
     */
    private long idUsuario;
    
    /**
     * Constructor vacío de la clase ComprobacionDTO.
     */
    public ComprobacionDTO() {
        
    }
	

    /**
     * Crea un nuevo objeto ComprobacionDTO con los valores proporcionados.
     * @param idEvento - El ID del evento.
     * @param idUsuario - El ID del usuario.
     */
    public ComprobacionDTO(long idEvento, long idUsuario) {
        super();
        this.idEvento = idEvento;
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el ID del evento.
     * @return long - El ID del evento.
     */
    public long getIdEvento() {
        return idEvento;
    }

    /**
     * Establece el ID del evento.
     * @param idEvento - El ID del evento a establecer.
     */
    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * Obtiene el ID del usuario.
     * @return long - El ID del usuario.
     */
    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     * @param idUsuario - El ID del usuario a establecer.
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
