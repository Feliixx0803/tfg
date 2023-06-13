package org.mnotario.angular.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * Esta clase representa un rol en el sistema.
 */
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "rol")
    private Collection<Usuario> usuarios;

    /**
     * Crea una instancia de la clase Rol.
     */
    public Rol() {
        this.nombre = "user";
        this.usuarios = new ArrayList<Usuario>();
    }

    /**
     * Crea una instancia de la clase Rol con los valores especificados.
     *
     * @param id     El identificador del rol.
     * @param nombre El nombre del rol.
     */
    public Rol(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Devuelve el identificador del rol.
     *
     * @return El identificador del rol.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del rol.
     *
     * @param id El identificador del rol.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del rol.
     *
     * @return El nombre del rol.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param nombre El nombre del rol.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la colección de usuarios asociados a este rol.
     *
     * @return La colección de usuarios asociados a este rol.
     */
    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la colección de usuarios asociados a este rol.
     *
     * @param usuarios La colección de usuarios asociados a este rol.
     */
    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
