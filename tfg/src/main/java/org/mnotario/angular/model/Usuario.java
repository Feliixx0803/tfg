package org.mnotario.angular.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Esta clase representa a un usuario en el sistema.
 */
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private String telefono;

    private String pwd;

    @ManyToOne
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private Collection<Inscripcion> inscripciones;

    @OneToMany(mappedBy = "gestor")
    private Collection<Evento> eventosGestionados;

    /**
     * Crea una instancia de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Crea una instancia de la clase Usuario con los valores especificados.
     *
     * @param id       El identificador del usuario.
     * @param nombre   El nombre del usuario.
     * @param email    El correo electrónico del usuario.
     * @param telefono El número de teléfono del usuario.
     * @param pwd      La contraseña del usuario.
     */
    public Usuario(Long id, String nombre, String email, String telefono, String pwd) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.pwd = pwd;
    }

    /**
     * Devuelve el identificador del usuario.
     *
     * @return El identificador del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param id El identificador del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email El correo electrónico del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el número de teléfono del usuario.
     *
     * @return El número de teléfono del usuario.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     *
     * @param telefono El número de teléfono del usuario.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param pwd La contraseña del usuario.
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Devuelve el rol asociado al usuario.
     *
     * @return El rol asociado al usuario.
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol asociado al usuario.
     *
     * @param rol El rol asociado al usuario.
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * Devuelve la colección de inscripciones del usuario.
     *
     * @return La colección de inscripciones del usuario.
     */
    public Collection<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    /**
     * Establece la colección de inscripciones del usuario.
     *
     * @param inscripciones La colección de inscripciones del usuario.
     */
    public void setInscripciones(Collection<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    /**
     * Devuelve la colección de eventos gestionados por el usuario.
     *
     * @return La colección de eventos gestionados por el usuario.
     */
    public Collection<Evento> getEventosGestionados() {
        return eventosGestionados;
    }

    /**
     * Establece la colección de eventos gestionados por el usuario.
     *
     * @param eventosGestionados La colección de eventos gestionados por el usuario.
     */
    public void setEventosGestionados(Collection<Evento> eventosGestionados) {
        this.eventosGestionados = eventosGestionados;
    }
}