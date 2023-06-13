package org.mnotario.angular.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.mnotario.angular.model.RegisterDTO;
import org.mnotario.angular.model.Rol;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.RolService;
import org.mnotario.angular.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Este controlador maneja el registro de los usuarios, incluyendo los servicios del usuario y del rol para su asignación.
 *
 */
@RestController
public class RegisterController {
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@Autowired
	private RolService rolService;
	
	
	 /**
	 * Maneja las solicitudes POST en la ruta "/register" para registrar un nuevo usuario.
	 * 
	 * @param registerDTO Datos del usuario proporcionados por el cliente para el registro.
	 * @return ResponseEntity con un mensaje indicando si el usuario se creó correctamente o un ResponseEntity con estado de error si falla.
	 */
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
	
		if(registerDTO.getEmail() == "" || registerDTO.getEmail() == null || 
		registerDTO.getPwd() == "" || registerDTO.getPwd() == null || 
		registerDTO.getNombre() == "" || registerDTO.getNombre() == null || 
		registerDTO.getTelefono() == "" || registerDTO.getTelefono() == null ) {
			
			return new ResponseEntity<>("Alguno de los campos está vacío.", HttpStatus.BAD_REQUEST);
		}
		else {
			String contrasenaEncriptada = BCrypt.hashpw(registerDTO.getPwd(), BCrypt.gensalt());
			Usuario usuario = new Usuario((long) 0, registerDTO.getNombre(), registerDTO.getEmail(), registerDTO.getTelefono(), contrasenaEncriptada);
			
			Rol rol = rolService.findRolById((long) 1);
			usuario.setRol(rol);
			
			usuarioService.addUsuario(usuario);
			
			return new ResponseEntity<>("Usuario creado", HttpStatus.CREATED);
		}
	}
}	
