package org.mnotario.angular.dto;

/**
 * Clase que representa los datos de un usuario.
 */
public class DatosUsuario {
	
	/**
	 * Nombre del usuario
	 */
    private String nombre;
    
    /**
     * Email del usuario
     */
    private String email;
    
    /**
     * Telefono del usuario
     */
    private String telefono;
    
    /**
     * nombre del Rol que tiene asignado el usuario
     */
    private String nombreRol;

    /**
     * Constructor por defecto de la clase DatosUsuario
     */
    public DatosUsuario() {

    }

    /**
     * Crea un nuevo objeto DatosUsuario con los valores proporcionados.
     * @param nombre - El nombre del usuario.
     * @param email - El correo electrónico del usuario.
     * @param telefono - El número de teléfono del usuario.
     * @param nombreRol - El nombre del rol del usuario.
     */
    public DatosUsuario(String nombre, String email, String telefono, String nombreRol) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.nombreRol = nombreRol;
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
     * Obtiene el correo electrónico del usuario.
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email El correo electrónico del usuario.
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
     * Obtiene el nombre del rol del usuario.
     * @return El nombre del rol del usuario.
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * Establece el nombre del rol del usuario.
     * @param nombreRol El nombre del rol del usuario.
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}

