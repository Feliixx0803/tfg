package org.mnotario.angular.repos;

import org.mnotario.angular.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interfaz define los métodos de acceso a datos para la entidad Inscripcion.
 */
public interface InscripcionRepo extends JpaRepository<Inscripcion, Long> {

    /**
     * Busca una inscripción por su identificador.
     *
     * @param id El identificador de la inscripción.
     * @return La inscripción encontrada, o null si no se encuentra.
     */
    Inscripcion findInscripcionById(Long id);
}
