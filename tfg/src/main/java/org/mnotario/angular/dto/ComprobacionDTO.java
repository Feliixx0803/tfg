package org.mnotario.angular.dto;

public class ComprobacionDTO {

	private long idEvento;
	private long idUsuario;
	
	public ComprobacionDTO() {
		super();
	}
	
	public ComprobacionDTO(long idEvento, long idUsuario) {
		super();
		this.idEvento = idEvento;
		this.idUsuario = idUsuario;
	}
	
	public long getIdEvento() {
		return idEvento;
	}
	
	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
}
