package org.mnotario.angular.repos;

import org.mnotario.angular.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interfaz define los métodos de acceso a datos para la entidad Usuario.
 */
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su identificador.
     *
     * @param id El identificador del usuario.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    Usuario findUsuarioById(Long id);

    /**
     * Busca un usuario por su email.
     *
     * @param email El email del usuario.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    Usuario findUsuarioByEmail(String email);

    /**
     * Busca un usuario por su nombre.
     *
     * @param nombre El nombre del usuario.
     * @return El usuario encontrado, o null si no se encuentra.
     */
    Usuario findUsuarioByNombre(String nombre);
}
