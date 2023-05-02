package org.mnotario.angular.repos;

import org.mnotario.angular.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepo extends JpaRepository<Rol, Long>{

	Rol findRolById(Long id);

}
