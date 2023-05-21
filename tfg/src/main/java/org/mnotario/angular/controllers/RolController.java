package org.mnotario.angular.controllers;

import java.util.List;

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

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

	private final RolService rolService;
	
	public RolController(RolService rolService) {
		this.rolService = rolService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Rol>> findAllRoles(){
		List<Rol> Roles = rolService.findAllRoles();
		return new ResponseEntity<>(Roles, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Rol> findRolById(@PathVariable("id") Long id){
		Rol Rol = rolService.findRolById(id);
		return new ResponseEntity<>(Rol, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Rol> addRol(@RequestBody Rol Rol){
		Rol nuevoRol = rolService.addRol(Rol);
		return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Rol> updateRol(@RequestBody Rol Rol){
		Rol RolAct = rolService.updateRol(Rol);
		return new ResponseEntity<>(RolAct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRol(@PathVariable("id") Long id){
		rolService.deleteRolById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
