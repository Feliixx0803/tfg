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

/**
 * Este controlador maneja las solicitudes relacionadas con los estados.
 * Proporciona operaciones CRUD para los estados y utiliza el servicio EstadoService para realizar las operaciones.
 */
@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoController {
	private final EstadoService estadoService;
	
	/**
	 * Constructor del controlador EstadoController.
	 * @param estadoService el servicio EstadoService utilizado para realizar las operaciones relacionadas con los estados.
	 */
	public EstadoController(EstadoService estadoService) {
		super();
		this.estadoService = estadoService;
	}
	
	/**
	 * Maneja la solicitud GET "/estado/all" para obtener todos los estados.
	 * @return una ResponseEntity que contiene una lista de EstadoDTO y un código de estado HTTP.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<EstadoDTO>> findAllEstados(){
		
		List<Estado> estados = estadoService.findAllEstados();
		List<EstadoDTO> estadoDTOs = new ArrayList<>();
		
		for(Estado estado:estados) {
			estadoDTOs.add(new EstadoDTO(estado.getId(), estado.getNombre(), estado.getInscripciones()));
		}
		
		return new ResponseEntity<>(estadoDTOs, HttpStatus.OK);
	}
		
	/**
	 * Maneja la solicitud GET "/estado/find/{id}" para obtener un estado por su ID.
	 * @param id el ID del estado a buscar.
	 * @return una ResponseEntity que contiene un EstadoDTO y un código de estado HTTP.
	 */
	@GetMapping("/find/{id}")
	public ResponseEntity<EstadoDTO> findEstadoById(@PathVariable("id") Long id){
		Estado estado = estadoService.findEstadoById(id);
		EstadoDTO estadoDTO = new EstadoDTO(estado.getId(), estado.getNombre(), estado.getInscripciones());
		return new ResponseEntity<>(estadoDTO, HttpStatus.OK);
	}
	
	/**
	 * Maneja la solicitud POST "/estado/add" para agregar un nuevo estado.
	 * @param estado el estado a agregar.
	 * @return una ResponseEntity que contiene un EstadoDTO y un código de estado HTTP.
	 */
	@PostMapping("/add")
	public ResponseEntity<EstadoDTO> addEstado(@RequestBody Estado estado){
		Estado nuevoEstado = estadoService.addEstado(estado);
		EstadoDTO nuevoEstadoDTO = new EstadoDTO(nuevoEstado.getId(), nuevoEstado.getNombre(), nuevoEstado.getInscripciones());
		return new ResponseEntity<>(nuevoEstadoDTO, HttpStatus.CREATED);
	}
	
	/**
	 * Maneja la solicitud PUT "/estado/update" para actualizar un estado existente.
	 * @param estado el estado a actualizar.
	 * @return una ResponseEntity que contiene un EstadoDTO y un código de estado HTTP.
	 */
	@PutMapping("/update")
	public ResponseEntity<EstadoDTO> updateEstado(@RequestBody Estado estado){
		Estado estadoAct = estadoService.updateEstado(estado);
		EstadoDTO estadoActDTO = new EstadoDTO(estadoAct.getId(), estadoAct.getNombre(), estadoAct.getInscripciones());

		return new ResponseEntity<>(estadoActDTO, HttpStatus.OK);
	}
	
	/**
	 * Maneja la solicitud DELETE "/estado/delete/{id}" para eliminar un estado por su ID.
	 * @param id el ID del estado a eliminar.
	 * @return una ResponseEntity con un código de estado HTTP.
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEstado(@PathVariable("id") Long id){
		estadoService.deleteEstadoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Maneja la solicitud POST "/estado/findByName/{nombre}" para verificar si existe un estado por su nombre.
	 * Si el estado existe, se devuelve el EstadoDTO correspondiente.
	 * Si no existe, se crea un nuevo estado con el nombre proporcionado y se devuelve su EstadoDTO.
	 * @param nombre el nombre del estado a buscar o crear.
	 * @return una ResponseEntity que contiene un EstadoDTO y un código de estado HTTP.
	 */
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
