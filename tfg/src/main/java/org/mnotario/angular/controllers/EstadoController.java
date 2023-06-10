package org.mnotario.angular.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mnotario.angular.dto.EstadoDTO;
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
	public ResponseEntity<List<EstadoDTO>> findAllEstados(){
		
		List<Estado> estados = estadoService.findAllEstados();
		List<EstadoDTO> estadoDTOs = new ArrayList<>();
		
		for(Estado estado:estados) {
			estadoDTOs.add(new EstadoDTO(estado.getId(), estado.getNombre(), estado.getInscripciones()));
		}
		
		return new ResponseEntity<>(estadoDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<EstadoDTO> findEstadoById(@PathVariable("id") Long id){
		Estado estado = estadoService.findEstadoById(id);
		EstadoDTO estadoDTO = new EstadoDTO(estado.getId(), estado.getNombre(), estado.getInscripciones());
		return new ResponseEntity<>(estadoDTO, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<EstadoDTO> addEstado(@RequestBody Estado estado){
		Estado nuevoEstado = estadoService.addEstado(estado);
		EstadoDTO nuevoEstadoDTO = new EstadoDTO(nuevoEstado.getId(), nuevoEstado.getNombre(), nuevoEstado.getInscripciones());
		return new ResponseEntity<>(nuevoEstadoDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EstadoDTO> updateEstado(@RequestBody Estado estado){
		Estado estadoAct = estadoService.updateEstado(estado);
		EstadoDTO estadoActDTO = new EstadoDTO(estadoAct.getId(), estadoAct.getNombre(), estadoAct.getInscripciones());

		return new ResponseEntity<>(estadoActDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEstado(@PathVariable("id") Long id){
		estadoService.deleteEstadoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/findByName/{nombre}")
	public ResponseEntity<EstadoDTO> verifyEstadoByName(@PathVariable("nombre") String nombre) {
	  Estado estado = estadoService.findEstadoByNombre(nombre);
	  
	  if (estado != null) {
		  EstadoDTO estadoDTO = new EstadoDTO(estado.getId(), estado.getNombre(), estado.getInscripciones());
		  return new ResponseEntity<>(estadoDTO, HttpStatus.OK);
	  } else {
	    Estado estadoInscrito = new Estado();
	    estadoInscrito.setNombre(nombre);
	    Estado estadoCreado = estadoService.addEstado(estadoInscrito);
	    EstadoDTO estadoCreadoDTO = new EstadoDTO(estadoCreado.getId(), estadoCreado.getNombre(), estadoCreado.getInscripciones());
	    return new ResponseEntity<>(estadoCreadoDTO, HttpStatus.OK);
	  }
	}


	
}
