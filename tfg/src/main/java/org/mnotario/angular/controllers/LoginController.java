package org.mnotario.angular.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.mnotario.angular.model.LoginDTO;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody LoginDTO loginDTO){
		
		if (loginDTO.getEmail() == "" || loginDTO.getPwd() == "") {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = usuarioService.findUsuarioByEmail(loginDTO.getEmail());
		
		if(usuario == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else if(!BCrypt.checkpw(loginDTO.getPwd(), usuario.getPwd())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		}
	}
}
