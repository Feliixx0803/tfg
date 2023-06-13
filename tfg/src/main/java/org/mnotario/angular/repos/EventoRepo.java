package org.mnotario.angular.repos;

import org.mnotario.angular.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interfaz define los métodos de acceso a datos para la entidad Evento.
 */
public interface EventoRepo extends JpaRepository<Evento, Long> {

    /**
     * Busca un evento por su identificador.
     *
     * @param id El identificador del evento.
     * @return El evento encontrado, o null si no se encuentra.
     */
    Evento findEventoById(Long id);

    /**
     * Busca un evento por su nombre.
     *
     * @param nombre El nombre del evento.
     * @return El evento encontrado, o null si no se encuentra.
     */
    Evento findEventoByNombre(String nombre);
}
