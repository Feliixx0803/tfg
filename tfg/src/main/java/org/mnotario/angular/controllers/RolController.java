package org.mnotario.angular.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mnotario.angular.dto.RolDTO;
import org.mnotario.angular.model.Rol;
import org.mnotario.angular.services.RolService;
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
 * Este controlador maneja las solicitudes relacionadas con los roles.
 * Proporciona operaciones CRUD para los roles.
 */
@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {
	
	private static final Logger logger = LogManager.getLogger(RolController.class);

	/**
     * Servicio de roles.
     */
	private final RolService rolService;
	
	/**
     * Constructor de RolController.
     * 
     * @param rolService Servicio de roles.
     */
	public RolController(RolService rolService) {
		this.rolService = rolService;
	}
	
	/**
     * Maneja las solicitudes GET en la ruta "/rol/all" para obtener todos los roles.
     * 
     * @return ResponseEntity con una lista de objetos RolDTO que representan los roles encontrados y el estado HTTP 200 (OK).
     */
	@GetMapping("/all")
	public ResponseEntity<List<RolDTO>> findAllRoles(){
		List<Rol> roles = rolService.findAllRoles();
		List<RolDTO> rolesDTO = new ArrayList<>();
		
		for(Rol rol:roles) {
			rolesDTO.add(new RolDTO(rol.getId(), rol.getNombre(), rol.getUsuarios()));
		}
		
		return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
	}
	
	/**
     * Maneja las solicitudes GET en la ruta "/rol/find/{id}" para obtener un rol por su ID.
     * 
     * @param id ID del rol a buscar.
     * @return ResponseEntity con un objeto RolDTO que representa el rol encontrado y el estado HTTP 200 (OK).
     */
	@GetMapping("/find/{id}")
	public ResponseEntity<RolDTO> findRolById(@PathVariable("id") Long id){
		Rol rol = rolService.findRolById(id);
		RolDTO rolDTO = new RolDTO(rol.getId(), rol.getNombre(), rol.getUsuarios());
		return new ResponseEntity<>(rolDTO, HttpStatus.OK);
	}
	
	/**
     * Maneja las solicitudes POST en la ruta "/rol/add" para agregar un nuevo rol.
     * 
     * @param nombre Nombre del rol a añadir.
     * @return ResponseEntity con un objeto RolDTO que representa el nuevo rol creado y el estado HTTP 201 (Creado).
     */
	@PostMapping("/add")
	public ResponseEntity<RolDTO> addRol(@RequestBody String nombre){
		Rol user = new Rol();
		Rol admin = new Rol();
		
		logger.info("AÑADIDO ROL USER");
		user.setId((long) 1);
		user.setNombre("user");
		logger.info("AÑADIDO ROL admin");
		admin.setId((long) 2);
		admin.setNombre("admin");
		
		Rol nuevoUser = rolService.addRol(user);
		Rol nuevoAdmin = rolService.addRol(admin);
		
		RolDTO nuevoRolDTO = new RolDTO(nuevoUser.getId(), nuevoUser.getNombre(), nuevoUser.getUsuarios());
		return new ResponseEntity<>(nuevoRolDTO, HttpStatus.CREATED);
	}
	
	/**
	 * Maneja las solicitudes PUT en la ruta "/rol/update" para actualizar un rol existente.
	 * 
	 * @param Rol El rol actualizado.
	 * @return ResponseEntity con un objeto RolDTO que representa el rol actualizado y el estado HTTP 200 (OK).
	 */
	@PutMapping("/update")
	public ResponseEntity<RolDTO> updateRol(@RequestBody Rol Rol){
		Rol rolAct = rolService.updateRol(Rol);
		RolDTO rolActDTO = new RolDTO(rolAct.getId(), rolAct.getNombre(), rolAct.getUsuarios());
		return new ResponseEntity<>(rolActDTO, HttpStatus.OK);
	}
	
	/**
     * Maneja las solicitudes DELETE en la ruta "/rol/delete/{id}" para eliminar un rol por su ID.
     * 
     * @param id ID del rol a eliminar.
     * @return ResponseEntity vacío y el estado HTTP 200 (OK).
     */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRol(@PathVariable("id") Long id){
		rolService.deleteRolById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
