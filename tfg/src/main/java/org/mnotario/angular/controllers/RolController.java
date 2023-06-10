package org.mnotario.angular.controllers;

import java.util.ArrayList;
import java.util.List;

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

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

	private final RolService rolService;
	
	public RolController(RolService rolService) {
		this.rolService = rolService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<RolDTO>> findAllRoles(){
		List<Rol> roles = rolService.findAllRoles();
		List<RolDTO> rolesDTO = new ArrayList<>();
		
		for(Rol rol:roles) {
			rolesDTO.add(new RolDTO(rol.getId(), rol.getNombre(), rol.getUsuarios()));
		}
		
		return new ResponseEntity<>(rolesDTO, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<RolDTO> findRolById(@PathVariable("id") Long id){
		Rol rol = rolService.findRolById(id);
		RolDTO rolDTO = new RolDTO(rol.getId(), rol.getNombre(), rol.getUsuarios());
		return new ResponseEntity<>(rolDTO, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<RolDTO> addRol(@RequestBody Rol Rol){
		Rol nuevoRol = rolService.addRol(Rol);
		RolDTO nuevoRolDTO = new RolDTO(nuevoRol.getId(), nuevoRol.getNombre(), nuevoRol.getUsuarios());
		return new ResponseEntity<>(nuevoRolDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<RolDTO> updateRol(@RequestBody Rol Rol){
		Rol rolAct = rolService.updateRol(Rol);
		RolDTO rolActDTO = new RolDTO(rolAct.getId(), rolAct.getNombre(), rolAct.getUsuarios());
		return new ResponseEntity<>(rolActDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRol(@PathVariable("id") Long id){
		rolService.deleteRolById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
