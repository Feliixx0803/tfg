package org.mnotario.angular.model;

/**
 * Clase que representa los datos de registro de un usuario.
 */
public class RegisterDTO {

	private String nombre;
	private String email;
	private String telefono;
	private String pwd;
	
	/**
	 * Constructor de la clase RegisterDTO.
	 * @param nombre El nombre del usuario.
	 * @param email El email del usuario.
	 * @param telefono El número de teléfono del usuario.
	 * @param pwd La contraseña del usuario.
	 */
	public RegisterDTO(String nombre, String email, String telefono, String pwd) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.pwd = pwd;
	}

	/**
	 * Obtiene el nombre del usuario.
	 * @return El nombre del usuario.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 * @param nombre El nombre del usuario.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * Obtiene el número de teléfono del usuario.
	 * @return El número de teléfono del usuario.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el número de teléfono del usuario.
	 * @param telefono El número de teléfono del usuario.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
