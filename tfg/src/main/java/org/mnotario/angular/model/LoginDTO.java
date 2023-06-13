package org.mnotario.angular.model;

/**
 * Clase que representa los datos de inicio de sesión de un usuario.
 */
public class LoginDTO {
	
	private String email;
	private String pwd;
	
	/**
	 * Constructor de la clase LoginDTO.
	 * @param email El email del usuario.
	 * @param pwd La contraseña del usuario.
	 */
	public LoginDTO(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	/**
	 * Obtiene el email del usuario.
	 * @return El email del usuario.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el email del usuario.
	 * @param email El email del usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * @return La contraseña del usuario.
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Establece la contraseña del usuario.
	 * @param pwd La contraseña del usuario.
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
