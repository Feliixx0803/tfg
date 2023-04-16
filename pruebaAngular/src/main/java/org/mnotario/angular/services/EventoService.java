package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Evento;
import org.mnotario.angular.repos.EventoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
	private final EventoRepo eventoRepositorio;

	@Autowired
	public EventoService(EventoRepo eventoRepositorio) {
		super();
		this.eventoRepositorio = eventoRepositorio;
	}
	
	public Evento addEvento(Evento evento) {
		return eventoRepositorio.save(evento);
	}
	
	public List<Evento> findAllEventos(){
		return eventoRepositorio.findAll();
	}
	
	public Evento updateEvento(Evento evento) {
		return eventoRepositorio.save(evento);
	}
	
	public Evento findEventoById(Long id) {
		return eventoRepositorio.findEventoById(id);
	}
	
	public void deleteEventoById(Long id) {
		eventoRepositorio.deleteById(id);
	}
	
	

}
