package org.mnotario.angular.controllers;

import java.util.List;

import org.mnotario.angular.model.Evento;
import org.mnotario.angular.services.EventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {
	private final EventoService eventoService;

	public EventoController(EventoService eventoService) {
		super();
		this.eventoService = eventoService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Evento>> findAllEventos(){
		List<Evento> eventos = eventoService.findAllEventos();
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Evento> findEventoById(@PathVariable("id") Long id){
		Evento evento = eventoService.findEventoById(id);
		return new ResponseEntity<>(evento, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Evento> addEvento(@RequestBody Evento Evento){
		Evento nuevoEvento = eventoService.addEvento(Evento);
		return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Evento> updateEvento(@RequestBody Evento Evento){
		Evento eventoAct = eventoService.updateEvento(Evento);
		return new ResponseEntity<>(eventoAct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEvento(@PathVariable("id") Long id){
		eventoService.deleteEventoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
