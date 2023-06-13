package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.repos.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase proporciona servicios relacionados con la entidad Usuario.
 */
@Service
public class UsuarioService {
    
    private final UsuarioRepo usuarioRepositorio;

    /**
     * Constructor de la clase UsuarioService.
     *
     * @param usuarioRepositorio Repositorio de Usuarios.
     */
    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    /**
     * Agrega un nuevo Usuario.
     *
     * @param usuario El Usuario a agregar.
     * @return El Usuario agregado.
     */
    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    /**
     * Obtiene todos los Usuarios.
     *
     * @return Una lista de todos los Usuarios.
     */
    public List<Usuario> findAllUsuarios() {
        return usuarioRepositorio.findAll();
    }

    /**
     * Actualiza un Usuario existente.
     *
     * @param usuario El Usuario a actualizar.
     * @return El Usuario actualizado.
     */
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    /**
     * Busca un Usuario por su identificador.
     *
     * @param id El identificador del Usuario.
     * @return El Usuario encontrado, o null si no se encuentra.
     */
    public Usuario findUsuarioById(Long id) {
        return usuarioRepositorio.findUsuarioById(id);
    }

    /**
     * Busca un Usuario por su nombre.
     *
     * @param nombre El nombre del Usuario.
     * @return El Usuario encontrado, o null si no se encuentra.
     */
    public Usuario findUsuarioByNombre(String nombre) {
        return usuarioRepositorio.findUsuarioByNombre(nombre);
    }

    /**
     * Elimina un Usuario por su identificador.
     *
     * @param id El identificador del Usuario a eliminar.
     */
    public void deleteUsuarioById(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    /**
     * Busca un Usuario por su dirección de correo electrónico.
     *
     * @param email La dirección de correo electrónico del Usuario.
     * @return El Usuario encontrado, o null si no se encuentra.
     */
    public Usuario findUsuarioByEmail(String email) {
        return usuarioRepositorio.findUsuarioByEmail(email);
    }
}
