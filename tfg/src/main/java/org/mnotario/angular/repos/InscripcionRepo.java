package org.mnotario.angular.repos;

import org.mnotario.angular.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepo extends JpaRepository<Inscripcion, Long>{
	Inscripcion findInscripcionById(Long id);
}
