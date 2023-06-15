package org.mnotario.angular.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mnotario.angular.dto.CrearEventoDTO;
import org.mnotario.angular.dto.EventoDTO;
import org.mnotario.angular.model.Evento;
import org.mnotario.angular.model.Inscripcion;
import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.services.EventoService;
import org.mnotario.angular.services.InscripcionService;
import org.mnotario.angular.services.UsuarioService;

/**
 * Este controlador maneja las solicitudes relacionadas con los eventos.
 * Proporciona operaciones CRUD para los eventos.
 */
@RestController
@RequestMapping("/evento")
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {
	
	private static final Logger logger = LogManager.getLogger(EventoController.class);
	
	@Autowired
	private final EventoService eventoService;

	@Autowired
	private final UsuarioService usuarioService;
	
	private final InscripcionService inscripcionService;
	
	/**
	 * Constructor de EventoController.
	 * 
	 * @param eventoService Servicio de eventos
	 * @param usuarioService Servicio de usuarios
	 * @param inscripcionService Servicio de inscripciones
	 */
	public EventoController(EventoService eventoService, UsuarioService usuarioService, InscripcionService inscripcionService) {
		super();
		this.eventoService = eventoService;
		this.usuarioService = usuarioService;
		this.inscripcionService = inscripcionService;
	}
	
	/**
	 * Maneja la solicitud GET para obtener todos los eventos.
	 * 
	 * @return ResponseEntity con la lista de EventoDTO y HttpStatus OK si la solicitud es exitosa
	 */
	@GetMapping("/all")
	public ResponseEntity<List<EventoDTO>> findAllEventos(){
		List<Evento> eventos = eventoService.findAllEventos();
		List<EventoDTO> eventoDTOs = new ArrayList<>();
		
		for(Evento e: eventos) {
			eventoDTOs.add(new EventoDTO(e));
		}
		return new ResponseEntity<>(eventoDTOs, HttpStatus.OK);
	}
	
	/**
	 * Maneja la solicitud GET para buscar el ID de un evento por su nombre.
	 * 
	 * @param nombre Nombre del evento
	 * @return ResponseEntity con el ID del evento y HttpStatus OK si la solicitud es exitosa
	 */
	@GetMapping("/findIdByNombre/{nombre}")
	public ResponseEntity<Long> findIdByNombre(@PathVariable("nombre") String nombre){
		Evento evento = eventoService.findEventoByNombre(nombre);
		
		return new ResponseEntity<>(evento.getId(), HttpStatus.OK);
	}
	
	/**
	 * Maneja la solicitud GET para buscar un evento por su ID.
	 * 
	 * @param id ID del evento
	 * @return ResponseEntity con el EventoDTO correspondiente y HttpStatus OK si la solicitud es exitosa
	 */
	@GetMapping("/find/{id}")
	public ResponseEntity<EventoDTO> findEventoById(@PathVariable("id") Long id){
		Evento evento = eventoService.findEventoById(id);
		EventoDTO eventoDTO = new EventoDTO(evento);
		
		return new ResponseEntity<>(eventoDTO, HttpStatus.OK);
	}
	
	/**
	 * Maneja la solicitud POST para agregar un nuevo evento.
	 * 
	 * @param eventoDTO DTO del evento a agregar
	 * @return ResponseEntity con el ID del nuevo evento y HttpStatus CREATED si la solicitud es exitosa,
	 *         o ResponseEntity con un mensaje de error y HttpStatus BAD_REQUEST si ocurre un error
	 */
	@PostMapping("/add")
	public ResponseEntity<String> addEvento(@RequestBody CrearEventoDTO eventoDTO){
		try {
			Evento evento = new Evento();
			Usuario gestor = usuarioService.findUsuarioById(eventoDTO.getIdGestor());
			logger.info("GESTOR RECOGIDO");
			evento.setGestor(gestor);
			logger.info("GESTOR ASIGNADO");
			
			evento.setNombre(eventoDTO.getNombre());
			evento.setFechaInicio(eventoDTO.getFechaInicio());
			evento.setFechaFin(eventoDTO.getFechaFin());
			evento.setDescripcion(eventoDTO.getDescripcion());
			evento.setUbicacion(eventoDTO.getUbicacion());
			
			Evento nuevoEvento = eventoService.addEvento(evento);
			logger.info("EVENTO GUARDADO - " + nuevoEvento.getId());
			
			return new ResponseEntity<>("" + nuevoEvento.getId(), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Maneja la solicitud PUT para actualizar un evento existente.
	 * 
	 * @param Evento Evento a actualizar
	 * @return ResponseEntity con el EventoDTO actualizado y HttpStatus OK si la solicitud es exitosa
	 */
	@PutMapping("/update")
	public ResponseEntity<EventoDTO> updateEvento(@RequestBody Evento Evento){
		Evento eventoAct = eventoService.updateEvento(Evento);
		EventoDTO eventoActDTO = new EventoDTO(eventoAct);
		return new ResponseEntity<>(eventoActDTO, HttpStatus.OK);
	}
	
	/**
	 * Elimina un evento y cancela las inscripciones asociadas.
	 *
	 * @param id el ID del evento a eliminar
	 * @return ResponseEntity con el estado de la respuesta
	 * @throws AddressException si ocurre un error en las direcciones de correo electrónico
	 * @throws MessagingException si ocurre un error al enviar el correo electrónico
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEvento(@PathVariable("id") Long id) throws AddressException, MessagingException{
		
		Evento e = eventoService.findEventoById(id);
		
		for(Inscripcion i: e.getInscripciones()) {
			Usuario u = i.getUsuario();
			String email = u.getEmail();
			
			Properties prop = new Properties();
			prop.put("mail.smtp.auth", true);
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
			prop.put("mail.smtp.port", "25");
			prop.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
			
			Session session = Session.getInstance(prop, new Authenticator() {
			    @Override
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication("d2ab7b2e38c7df", "28db20b61a429f");
			    }
			});
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("info@eventify.es"));
			message.setRecipients(
			  Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Mail Subject");

			String msg = 
					"Hola " + u.getNombre() + ", el evento " + e.getNombre() + " ha sido cancelado." +
					"Su inscripción ha sido cancelada. Disculpe las molestias.";

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			logger.info("EMAIL ENVIADO A: " + email);
			
			inscripcionService.deleteInscripcionById(i.getId());
		}
		
		eventoService.deleteEventoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Maneja la solicitud GET para buscar un evento por su nombre.
	 * 
	 * @param nombre Nombre del evento
	 * @return ResponseEntity con el EventoDTO correspondiente y HttpStatus OK si la solicitud es exitosa
	 */
	@GetMapping("/findNombre/{nombre}")
	public ResponseEntity<EventoDTO> findEventoByNombre(@PathVariable("nombre") String nombre){
		logger.info("NOMBRE BUSCADO: " + nombre);
		Evento evento = eventoService.findEventoByNombre(nombre);
		EventoDTO eventoDTO = new EventoDTO(evento);
		return new ResponseEntity<>(eventoDTO, HttpStatus.OK);
	}
	
}
