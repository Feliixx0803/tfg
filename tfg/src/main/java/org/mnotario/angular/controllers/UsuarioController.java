package org.mnotario.angular.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
import org.mnotario.angular.dto.DatosEvento;
import org.mnotario.angular.dto.DatosUsuario;
import org.mnotario.angular.dto.UsuarioDTO;
import org.mnotario.angular.model.Evento;
import org.mnotario.angular.model.Inscripcion;
import org.mnotario.angular.model.Rol;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.InscripcionService;
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

/**
 * Este controlador maneja las solicitudes relacionadas con los usuarios.
 * Proporciona operaciones CRUD para los usuarios.
 */
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    /**
     * Servicio de usuarios.
     */
    private final UsuarioService usuarioService;
    
    /**
     * Servicio de roles.
     */
    private final RolService rolService;
    
    /**
     * Servicio de inscripciones.
     */
    private final InscripcionService inscripcionService;
    
    private static final Logger logger = LogManager.getLogger(UsuarioController.class);
    
    /**
     * Constructor de UsuarioController.
     * 
     * @param usuarioService Servicio de usuarios.
     * @param rolService     Servicio de roles.
     */
    @Autowired
    public UsuarioController(UsuarioService usuarioService, RolService rolService, InscripcionService inscripcionService) {
        this.usuarioService = usuarioService;
        this.rolService = rolService;
        this.inscripcionService = inscripcionService;
    }
	
	/**
     * Retorna todos los usuarios existentes en forma de una lista de objetos UsuarioDTO.
     *
     * @return ResponseEntity con la lista de usuarios y el estado HTTP 200 (OK).
     */
	@GetMapping("/all")
	public ResponseEntity<List<UsuarioDTO>> findAllUsuarios(){
		List<Usuario> usuarios = usuarioService.findAllUsuarios();
		List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
		
		for(Usuario usuario:usuarios) {
			usuarioDTOs.add(new UsuarioDTO(usuario));
		}
		
		return new ResponseEntity<>(usuarioDTOs, HttpStatus.OK);
	}
	

    /**
     * Busca un usuario por su ID y lo retorna en forma de un objeto UsuarioDTO.
     *
     * @param id ID del usuario a buscar.
     * @return ResponseEntity con el usuario encontrado y el estado HTTP 200 (OK).
     */
	@GetMapping("/find/{id}")
	public ResponseEntity<UsuarioDTO> findUsuarioById(@PathVariable("id") Long id){
		Usuario usuario = usuarioService.findUsuarioById(id);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}
	
	/**
     * Busca un usuario por su nombre y retorna un objeto DatosUsuario que contiene información básica del usuario.
     *
     * @param nombre Nombre del usuario a buscar.
     * @return ResponseEntity con el usuario encontrado y el estado HTTP 200 (OK).
     */
	@GetMapping("/findByName/{nombre}")
	public ResponseEntity<DatosUsuario> findUsuarioByNombre(@PathVariable("nombre") String nombre){
		Usuario usuario = usuarioService.findUsuarioByNombre(nombre);
		DatosUsuario usuarioDTO = new DatosUsuario(usuario.getNombre(), usuario.getEmail(), usuario.getTelefono(), usuario.getRol().getNombre());
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}
	
	 /**
     * Busca un usuario por su nombre y retorna su ID.
     *
     * @param nombre Nombre del usuario a buscar.
     * @return ResponseEntity con el ID del usuario y el estado HTTP 200 (OK).
     */
	@GetMapping("/findIdByName/{nombre}")
	public ResponseEntity<Long> findIdByNombre(@PathVariable("nombre") String nombre){
		Usuario usuario = usuarioService.findUsuarioByNombre(nombre);
		return new ResponseEntity<>(usuario.getId(), HttpStatus.OK);
	}
	
	/**
     * Agrega un nuevo usuario.
     *
     * @param usuario Objeto Usuario a agregar.
     * @return ResponseEntity con el ID del nuevo usuario creado y el estado HTTP 201 (CREATED).
     *         Si ocurre algún error, devuelve un mensaje de error con el estado HTTP 400 (BAD REQUEST).
     */
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
	
	/**
     * Actualiza un usuario existente.
     *
     * @param usuarioDTO Objeto DatosUsuario actualizado.
     * @param id         ID del usuario a actualizar.
     * @return ResponseEntity con el objeto DatosUsuario que representa el usuario actualizado y el estado HTTP 200 (OK).
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<DatosUsuario> updateUsuario(@RequestBody DatosUsuario usuarioDTO, @PathVariable("id") Long id){
		Usuario usuario = usuarioService.findUsuarioById(id);
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setTelefono(usuarioDTO.getTelefono());
		Usuario usuarioAct = usuarioService.updateUsuario(usuario);
		DatosUsuario usuarioActDTO = new DatosUsuario(usuarioAct.getNombre(), usuarioAct.getEmail(), usuarioAct.getEmail(), usuarioAct.getRol().getNombre());
		return new ResponseEntity<>(usuarioActDTO, HttpStatus.OK);
	}
	
	/**
     * Elimina un usuario por su ID.
     *
     * @param id ID del usuario a eliminar.
     * @return ResponseEntity vacío y el estado HTTP 200 (OK).
     */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") Long id){
		usuarioService.deleteUsuarioById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	 /**
     * Obtiene una lista de nombres de eventos a los que un usuario está inscrito.
     *
     * @param nombre Nombre del usuario.
     * @return ResponseEntity con la lista de nombres de eventos y el estado HTTP 200 (OK).
     */
	@GetMapping("/getInscritos/{nombre}")
	public ResponseEntity<List<String>> getInscritos(@PathVariable("nombre") String nombre){
		Usuario usuario = usuarioService.findUsuarioByNombre(nombre);
		List<String> nombres = new ArrayList<>();
		
		for(Inscripcion i: usuario.getInscripciones()) {
			nombres.add(i.getEvento().getNombre());
		}
		
		return new ResponseEntity<>(nombres, HttpStatus.OK);
	}
	
	/**
     * Obtiene una lista de eventos que son gestionados por un usuario.
     *
     * @param nombre Nombre del usuario.
     * @return ResponseEntity con la lista de eventos y el estado HTTP 200 (OK).
     */
	@GetMapping("/getGestionados/{nombre}")
	public ResponseEntity<List<DatosEvento>> getGestionados(@PathVariable("nombre") String nombre){
		Usuario usuario = usuarioService.findUsuarioByNombre(nombre);
		
		List<DatosEvento> listaDatos = new ArrayList<>();
		
		for(Evento e: usuario.getEventosGestionados()) {
			String nombreEvento = e.getNombre();
			
			int usuariosInscritos = e.getInscripciones().size();
			
			logger.info(nombreEvento + "/" + usuariosInscritos);
			
			listaDatos.add(new DatosEvento(nombreEvento, usuariosInscritos));
		}
		
		return new ResponseEntity<>(listaDatos, HttpStatus.OK);
	}
	
	/**
	 * Maneja la solicitud DELETE para eliminar una inscripción según el usuario y evento asociados.
	 * 
	 * @param idUsuario ID del usuario asociado a la inscripción
	 * @param idEvento ID del evento asociado a la inscripción
	 * @return ResponseEntity con HttpStatus OK si la solicitud es exitosa
	 */
	@DeleteMapping("/deleteInscripcion/{idUsuario}/{idEvento}")
	public ResponseEntity<?> deleteInscripcion(@PathVariable("idUsuario") long idUsuario, @PathVariable("idEvento") long idEvento) {
		Usuario usuario = usuarioService.findUsuarioById(idUsuario);
		
		logger.info("USUARIO: " + usuario.getNombre());
		
		Inscripcion inscripcion = new Inscripcion();
		
		for(Inscripcion i: usuario.getInscripciones()) {
			
			if(i.getEvento().getId() == idEvento) {
				inscripcion = i;
			}
		}
		
		usuario.getInscripciones().remove(inscripcion);
		
		inscripcionService.deleteInscripcionById(inscripcion.getId());
		Usuario nuevoUsuario = usuarioService.updateUsuario(usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
