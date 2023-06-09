package org.mnotario.angular.controllers;

import java.util.List;
import java.util.Map;

import org.mnotario.angular.model.Estado;
import org.mnotario.angular.services.EstadoService;
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
@RequestMapping("/estado")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {
	private final EstadoService estadoService;

	public EstadoController(EstadoService estadoService) {
		super();
		this.estadoService = estadoService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Estado>> findAllEstados(){
		List<Estado> Estados = estadoService.findAllEstados();
		return new ResponseEntity<>(Estados, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Estado> findEstadoById(@PathVariable("id") Long id){
		Estado estado = estadoService.findEstadoById(id);
		return new ResponseEntity<>(estado, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Estado> addEstado(@RequestBody Estado estado){
		Estado nuevoEstado = estadoService.addEstado(estado);
		return new ResponseEntity<>(nuevoEstado, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Estado> updateEstado(@RequestBody Estado estado){
		Estado EstadoAct = estadoService.updateEstado(estado);
		return new ResponseEntity<>(EstadoAct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEstado(@PathVariable("id") Long id){
		estadoService.deleteEstadoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/findByName/{nombre}")
	public ResponseEntity<Estado> verifyEstadoByName(@PathVariable("nombre") String nombre) {
	  Estado estado = estadoService.findEstadoByNombre(nombre);
	  
	  if (estado != null) {
	    return new ResponseEntity<>(estado, HttpStatus.OK);
	  } else {
	    Estado estadoInscrito = new Estado();
	    estadoInscrito.setNombre(nombre);
	    estadoService.addEstado(estadoInscrito);
	    return new ResponseEntity<>(estadoInscrito, HttpStatus.OK);
	  }
	}


	
}
