package org.mnotario.angular.repos;

import org.mnotario.angular.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interfaz define los métodos de acceso a datos para la entidad Rol.
 */
public interface RolRepo extends JpaRepository<Rol, Long> {

    /**
     * Busca un rol por su identificador.
     *
     * @param id El identificador del rol.
     * @return El rol encontrado, o null si no se encuentra.
     */
    Rol findRolById(Long id);
}
