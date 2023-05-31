package org.mnotario.angular.controllers;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
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
	public ResponseEntity<List<Usuario>> findAllUsuarios(){
		List<Usuario> usuarios = usuarioService.findAllUsuarios();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Usuario> findUsuarioById(@PathVariable("id") Long id){
		Usuario usuario = usuarioService.findUsuarioById(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/findByName/{nombre}")
	public ResponseEntity<Usuario> findUsuarioByNombre(@PathVariable("nombre") String nombre){
		Usuario usuario = usuarioService.findUsuarioByNombre(nombre);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario){
		Rol rol = rolService.findRolById(usuario.getRol().getId());
		usuario.setRol(rol);
		
		//HASH DE PWD
		String passwd = usuario.getPwd();
		usuario.setPwd(BCrypt.hashpw(passwd, BCrypt.gensalt()));
		
		Usuario nuevoUsuario = usuarioService.addUsuario(usuario);
		return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
		Usuario usuarioAct = usuarioService.updateUsuario(usuario);
		return new ResponseEntity<>(usuarioAct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id){
		usuarioService.deleteUsuarioById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
