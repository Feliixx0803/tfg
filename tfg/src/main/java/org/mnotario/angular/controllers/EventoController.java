package org.mnotario.angular.controllers;

import java.util.List;

import org.mnotario.angular.model.Evento;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.EventoService;
import org.mnotario.angular.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/evento")
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {
	
	private static final Logger logger = LogManager.getLogger(EventoController.class);
	
	@Autowired
	private final EventoService eventoService;

	@Autowired
	private final UsuarioService usuarioService;
	
	public EventoController(EventoService eventoService, UsuarioService usuarioService) {
		super();
		this.eventoService = eventoService;
		this.usuarioService = usuarioService;
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
	public ResponseEntity<String> addEvento(@RequestBody Evento evento) throws Exception{
		try {
			Usuario gestor = usuarioService.findUsuarioById(evento.getGestor().getId());
			logger.info("GESTOR RECOGIDO");
			evento.setGestor(gestor);
			logger.info("GESTOR ASIGNADO");
			Evento nuevoEvento = eventoService.addEvento(evento);
			logger.info("EVENTO GUARDADO - " + nuevoEvento.getId());
			return new ResponseEntity<>("" + nuevoEvento.getId(), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
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
	
	@GetMapping("/findNombre/{nombre}")
	public ResponseEntity<Evento> findEventoByNombre(@PathVariable("nombre") String nombre){
		logger.info("NOMBRE BUSCADO: " + nombre);
		Evento evento = eventoService.findEventoByNombre(nombre);
		return new ResponseEntity<>(evento, HttpStatus.OK);
	}
	
}
