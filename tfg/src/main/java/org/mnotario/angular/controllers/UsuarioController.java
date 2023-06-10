package org.mnotario.angular.controllers;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.mnotario.angular.dto.DatosUsuario;
import org.mnotario.angular.dto.UsuarioDTO;
import org.mnotario.angular.model.Rol;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.RolService;
import org.mnotario.angular.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private final UsuarioService usuarioService;
	
	@Autowired
	private final RolService rolService;
	
	public UsuarioController(UsuarioService usuarioService, RolService rolservice) {
		this.usuarioService = usuarioService;
		this.rolService = rolservice;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UsuarioDTO>> findAllUsuarios(){
		List<Usuario> usuarios = usuarioService.findAllUsuarios();
		List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
		
		for(Usuario usuario:usuarios) {
			usuarioDTOs.add(new UsuarioDTO(usuario));
		}
		
		return new ResponseEntity<>(usuarioDTOs, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<UsuarioDTO> findUsuarioById(@PathVariable("id") Long id){
		Usuario usuario = usuarioService.findUsuarioById(id);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}
	
	@GetMapping("/findByName/{nombre}")
	public ResponseEntity<DatosUsuario> findUsuarioByNombre(@PathVariable("nombre") String nombre){
		Usuario usuario = usuarioService.findUsuarioByNombre(nombre);
		DatosUsuario usuarioDTO = new DatosUsuario(usuario.getNombre(), usuario.getEmail(), usuario.getTelefono(), usuario.getRol().getNombre());
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}
	
	@GetMapping("/findIdByName/{nombre}")
	public ResponseEntity<Long> findIdByNombre(@PathVariable("nombre") String nombre){
		Usuario usuario = usuarioService.findUsuarioByNombre(nombre);
		return new ResponseEntity<>(usuario.getId(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUsuario(@RequestBody Usuario usuario){
		try {
			Rol rol = rolService.findRolById(usuario.getRol().getId());
			usuario.setRol(rol);
			
			//HASH DE PWD
			String passwd = usuario.getPwd();
			usuario.setPwd(BCrypt.hashpw(passwd, BCrypt.gensalt()));
			
			Usuario nuevoUsuario = usuarioService.addUsuario(usuario);
			return new ResponseEntity<>("" + nuevoUsuario.getId(), HttpStatus.CREATED);
		} 
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<UsuarioDTO> updateUsuario(
			@RequestBody Usuario usuario){
		Usuario usuarioAct = usuarioService.updateUsuario(usuario);
		UsuarioDTO usuarioActDTO = new UsuarioDTO(usuarioAct);
		return new ResponseEntity<>(usuarioActDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id){
		usuarioService.deleteUsuarioById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
