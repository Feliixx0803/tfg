package org.mnotario.angular.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.mnotario.angular.dto.DatosUsuario;
import org.mnotario.angular.model.LoginDTO;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Este controlador maneja el login de los usuarios, incluyendo los servicios del usuario.
 *
 */
@RestController
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	
	/**
     * Maneja las solicitudes POST en la ruta "/login" para iniciar sesión.
     * 
     * @param loginDTO Datos de inicio de sesión proporcionados por el cliente.
     * @return ResponseEntity con los datos del usuario si el inicio de sesión es exitoso, o un ResponseEntity con estado de error si falla.
     */
	@PostMapping("/login")
	public ResponseEntity<DatosUsuario> login(@RequestBody LoginDTO loginDTO){
		
		if (loginDTO.getEmail() == "" || loginDTO.getPwd() == "") {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = usuarioService.findUsuarioByEmail(loginDTO.getEmail());
		DatosUsuario datos = new DatosUsuario();
		datos.setNombre(usuario.getNombre());
		
		if(datos.getNombre() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else if(!BCrypt.checkpw(loginDTO.getPwd(), usuario.getPwd())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(datos, HttpStatus.OK);
		}
	}
}
