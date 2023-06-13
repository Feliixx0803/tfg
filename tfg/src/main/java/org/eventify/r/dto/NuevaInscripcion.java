package org.mnotario.angular.dto;

import java.util.Date;

public class NuevaInscripcion {

	private Long idEvento;
	private Long idUsuario;
	private Long idEstado;
	private Date fecha;
	
	public NuevaInscripcion() {
		
	}

	public NuevaInscripcion(Long idEvento, Long idUsuario, Long idEstado, Date fecha) {
		super();
		this.idEvento = idEvento;
		this.idUsuario = idUsuario;
		this.idEstado = idEstado;
		this.fecha = fecha;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
