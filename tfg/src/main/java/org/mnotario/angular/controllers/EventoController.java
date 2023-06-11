package org.mnotario.angular.controllers;

import java.util.ArrayList;
import java.util.List;

import org.mnotario.angular.dto.CrearEventoDTO;
import org.mnotario.angular.dto.EventoDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<EventoDTO>> findAllEventos(){
		List<Evento> eventos = eventoService.findAllEventos();
		List<EventoDTO> eventoDTOs = new ArrayList<>();
		
		for(Evento e: eventos) {
			eventoDTOs.add(new EventoDTO(e));
		}
		return new ResponseEntity<>(eventoDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/findIdByNombre/{nombre}")
	public ResponseEntity<Long> findIdByNombre(@PathVariable("nombre") String nombre){
		Evento evento = eventoService.findEventoByNombre(nombre);
		
		return new ResponseEntity<>(evento.getId(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<EventoDTO> findEventoById(@PathVariable("id") Long id){
		Evento evento = eventoService.findEventoById(id);
		EventoDTO eventoDTO = new EventoDTO(evento);
		
		return new ResponseEntity<>(eventoDTO, HttpStatus.OK);
	}
	
	/*@PostMapping("/add")
	public ResponseEntity<String> addEvento(
			@RequestParam("nombre") String nombre,
			@RequestParam("fechaInicio") String fechaInicioString,
			@RequestParam("fechaFin") String fechaFinString,
			@RequestParam("descripcion") String descripción,
			@RequestParam("imagen") MultipartFile imagen,
			@RequestParam("gestor") Usuario gestor
			) throws Exception{
		
		LocalDate fechaInicio = LocalDate.parse(fechaInicioString, DateTimeFormatter.ISO_DATE);
		LocalDate fechaFin = LocalDate.parse(fechaFinString, DateTimeFormatter.ISO_DATE);
		
		Evento evento = new Evento((long) 0, nombre, fechaInicio, fechaFin, descripción, imagen);
		
		try {
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
	}*/
	
	@PostMapping("/add")
	public ResponseEntity<String> addEvento(@RequestBody CrearEventoDTO eventoDTO){
		try {
			Evento evento = new Evento();
			Usuario gestor = usuarioService.findUsuarioById(eventoDTO.getIdGestor());
			logger.info("GESTOR RECOGIDO");
			evento.setGestor(gestor);
			logger.info("GESTOR ASIGNADO");
			
			evento.setNombre(eventoDTO.getNombre());
			evento.setFechaInicio(eventoDTO.getFechaInicio());
			evento.setFechaFin(eventoDTO.getFechaFin());
			evento.setDescripcion(eventoDTO.getDescripcion());
			evento.setUbicacion(eventoDTO.getUbicacion());
			
			Evento nuevoEvento = eventoService.addEvento(evento);
			logger.info("EVENTO GUARDADO - " + nuevoEvento.getId());
			
			return new ResponseEntity<>("" + nuevoEvento.getId(), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<EventoDTO> updateEvento(@RequestBody Evento Evento){
		Evento eventoAct = eventoService.updateEvento(Evento);
		EventoDTO eventoActDTO = new EventoDTO(eventoAct);
		return new ResponseEntity<>(eventoActDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEvento(@PathVariable("id") Long id){
		eventoService.deleteEventoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/findNombre/{nombre}")
	public ResponseEntity<EventoDTO> findEventoByNombre(@PathVariable("nombre") String nombre){
		logger.info("NOMBRE BUSCADO: " + nombre);
		Evento evento = eventoService.findEventoByNombre(nombre);
		EventoDTO eventoDTO = new EventoDTO(evento);
		return new ResponseEntity<>(eventoDTO, HttpStatus.OK);
	}
	
}
