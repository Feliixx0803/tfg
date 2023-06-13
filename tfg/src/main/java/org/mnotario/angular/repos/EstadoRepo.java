package org.mnotario.angular.repos;

import org.mnotario.angular.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interfaz define los métodos de acceso a datos para la entidad Estado.
 */
public interface EstadoRepo extends JpaRepository<Estado, Long> {

    /**
     * Busca un estado por su identificador.
     *
     * @param id El identificador del estado.
     * @return El estado encontrado, o null si no se encuentra.
     */
    Estado findEstadoById(Long id);

    /**
     * Busca un estado por su nombre.
     *
     * @param nombre El nombre del estado.
     * @return El estado encontrado, o null si no se encuentra.
     */
    Estado findEstadoByNombre(String nombre);
}
