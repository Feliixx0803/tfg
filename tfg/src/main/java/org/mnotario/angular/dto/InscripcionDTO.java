package org.mnotario.angular.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.mnotario.angular.model.Estado;
import org.mnotario.angular.model.Evento;
import org.mnotario.angular.model.Usuario;

public class InscripcionDTO implements Serializable{
	
	private Long id;
	private Date fecha;
	private Estado estado;
	private Usuario usuario;
	private Evento evento;
	
	public InscripcionDTO() {
		super();
	}
	
	public InscripcionDTO(Long id, Date fecha, Estado estado, Usuario usuario, Evento evento) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.usuario = usuario;
		this.evento = evento;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Evento getEvento() {
		return evento;
	}
	
	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
