package org.mnotario.angular.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mnotario.angular.dto.ComprobacionDTO;
import org.mnotario.angular.dto.InscripcionDTO;
import org.mnotario.angular.dto.NuevaInscripcion;
import org.mnotario.angular.model.Estado;
import org.mnotario.angular.model.Evento;
import org.mnotario.angular.model.Inscripcion;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.EstadoService;
import org.mnotario.angular.services.EventoService;
import org.mnotario.angular.services.InscripcionService;
import org.mnotario.angular.services.UsuarioService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/inscripcion")
@CrossOrigin(origins = "http://localhost:4200")
public class InscripcionController {
	private final InscripcionService inscripcionService;
	private final UsuarioService usuarioService;
	private final EventoService eventoService;
	private final EstadoService estadoService;
	
	private static final Logger logger = LogManager.getLogger(InscripcionController.class);
	
	public InscripcionController(InscripcionService inscripcionService, UsuarioService usuarioService, EventoService eventoService, EstadoService estadoService) {
		super();
		this.inscripcionService = inscripcionService;
		this.usuarioService = usuarioService;
		this.eventoService = eventoService;
		this.estadoService = estadoService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<InscripcionDTO>> findAllInscripciones(){
		List<Inscripcion> inscripciones = inscripcionService.findAllInscripciones();
		List<InscripcionDTO> inscripcionesDTO = new ArrayList<>();
		
		for(Inscripcion i:inscripciones) {
			inscripcionesDTO.add(new InscripcionDTO(i.getId(), i.getFecha(), i.getEstado(), i.getUsuario(), i.getEvento()));
		}
		
		return new ResponseEntity<>(inscripcionesDTO, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<InscripcionDTO> findInscripcionById(@PathVariable("id") Long id){
		Inscripcion inscripcion = inscripcionService.findInscripcionesById(id);
		InscripcionDTO inscripcionDTO = new InscripcionDTO(inscripcion.getId(), inscripcion.getFecha(), inscripcion.getEstado(), inscripcion.getUsuario(), inscripcion.getEvento());
		return new ResponseEntity<>(inscripcionDTO, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<InscripcionDTO> addInscripcion(@RequestBody InscripcionDTO inscripcionDTO){
		
		Inscripcion inscripcion = new Inscripcion();
		
		Usuario usuario = usuarioService.findUsuarioById(inscripcionDTO.getUsuario().getId());
		inscripcion.setUsuario(usuario);
		
		logger.info("USUARIO A INSCRIBIR: " + usuario.getNombre());
		
		Evento evento = eventoService.findEventoById(inscripcionDTO.getEvento().getId());
		inscripcion.setEvento(evento);
		
		logger.info("EVENTO A INSCRIBIR: " + evento.getNombre());
		
		Estado estado = estadoService.findEstadoById(inscripcionDTO.getEstado().getId());
		inscripcion.setEstado(estado);
		
		Inscripcion nuevaInscripcion = inscripcionService.addInscripcion(inscripcion);
		
		InscripcionDTO nuevaInscripcionDTO = new InscripcionDTO(nuevaInscripcion.getId(), nuevaInscripcion.getFecha(), nuevaInscripcion.getEstado(), nuevaInscripcion.getUsuario(), nuevaInscripcion.getEvento());
		
		logger.info("INSCRIPCION QUE LE VOY A PASAR: " + nuevaInscripcionDTO.getUsuario().getInscripciones());;
		
		return new ResponseEntity<>(nuevaInscripcionDTO, HttpStatus.CREATED);
	}
	
	@PostMapping("/adddto")
	public ResponseEntity<String> addInscripcion(@RequestBody NuevaInscripcion inscripcionDTO){
			
		Inscripcion inscripcion = new Inscripcion();
		
		Usuario usuario = usuarioService.findUsuarioById(inscripcionDTO.getIdUsuario());
		inscripcion.setUsuario(usuario);
		
		logger.info("USUARIO A INSCRIBIR: " + usuario.getNombre());
		
		Evento evento = eventoService.findEventoById(inscripcionDTO.getIdEvento());
		inscripcion.setEvento(evento);
		
		logger.info("EVENTO A INSCRIBIR: " + evento.getNombre());
		
		Estado estado = estadoService.findEstadoById(inscripcionDTO.getIdEstado());
		inscripcion.setEstado(estado);
        
        inscripcion.setFecha(inscripcionDTO.getFecha());
		
		Inscripcion i = inscripcionService.addInscripcion(inscripcion);
		
		logger.info("INSCRIPCION CREADA: " + i.getId());
		
		return new ResponseEntity<>("", HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<InscripcionDTO> updateInscripcion(@RequestBody Inscripcion inscripcion){
		Inscripcion iAct = inscripcionService.updateInscripciones(inscripcion);
		InscripcionDTO inscripcionActDTO = new InscripcionDTO(iAct.getId(), iAct.getFecha(), iAct.getEstado(), iAct.getUsuario(), iAct.getEvento());
		return new ResponseEntity<>(inscripcionActDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteInscripcion(@PathVariable("id") Long id){
		inscripcionService.deleteInscripcionById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/comprobarRepeticiones/{idEvento}/{idUsuario}")
	public ResponseEntity<Boolean> comprobarRepeticiones(@PathVariable("idEvento") long idEvento, @PathVariable("idUsuario") long idUsuario){
		
		logger.info("IDS: " + idEvento + "/" + idUsuario);
		
		Usuario usuario = usuarioService.findUsuarioById(idUsuario);
		
		Boolean respuesta = false;
		
		for(Inscripcion i: usuario.getInscripciones()) {
			respuesta = (i.getEvento().getId() == idEvento) ? true : false;
		}
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
}
