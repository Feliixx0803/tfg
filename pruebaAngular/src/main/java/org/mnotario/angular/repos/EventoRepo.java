package org.mnotario.angular.repos;

import org.mnotario.angular.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepo extends JpaRepository<Evento, Long>{
	Evento findEventoById(Long id);
}
