package org.mnotario.angular.repos;

import org.mnotario.angular.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

	Usuario findUsuarioById(Long id);

	Usuario findUsuarioByEmail(String email);

	Usuario findUsuarioByNombre(String nombre);

}
