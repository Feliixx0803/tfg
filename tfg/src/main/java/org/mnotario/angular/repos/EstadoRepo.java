package org.mnotario.angular.repos;

import org.mnotario.angular.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepo extends JpaRepository<Estado, Long>{
	Estado findEstadoById(Long id);
}
