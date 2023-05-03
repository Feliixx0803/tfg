package org.mnotario.angular.controllers;

import java.util.List;

import org.mnotario.angular.model.Inscripcion;
import org.mnotario.angular.model.Rol;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.InscripcionService;
import org.mnotario.angular.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionController {
	private final InscripcionService inscripcionService;
	private final UsuarioService usuarioService;
	
	public InscripcionController(InscripcionService inscripcionService, UsuarioService usuarioService) {
		super();
		this.inscripcionService = inscripcionService;
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Inscripcion>> findAllInscripciones(){
		List<Inscripcion> inscripciones = inscripcionService.findAllInscripciones();
		return new ResponseEntity<>(inscripciones, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Inscripcion> findInscripcionById(@PathVariable("id") Long id){
		Inscripcion inscripcion = inscripcionService.findInscripcionesById(id);
		return new ResponseEntity<>(inscripcion, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Inscripcion> addInscripcion(@RequestBody Inscripcion inscripcion){
		Usuario usuario= usuarioService.findUsuarioById(inscripcion.getUsuario().getId());
		inscripcion.setUsuario(usuario);
		Inscripcion nuevaInscripcion = inscripcionService.addInscripcion(inscripcion);	
		return new ResponseEntity<>(nuevaInscripcion, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Inscripcion> updateInscripcion(@RequestBody Inscripcion inscripcion){
		Inscripcion inscripcionAct = inscripcionService.updateInscripciones(inscripcion);
		return new ResponseEntity<>(inscripcionAct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteInscripcion(@PathVariable("id") Long id){
		inscripcionService.deleteInscripcionById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
