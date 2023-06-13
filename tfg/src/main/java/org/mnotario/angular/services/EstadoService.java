package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Estado;
import org.mnotario.angular.repos.EstadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase proporciona servicios relacionados con la entidad Estado.
 */
@Service
public class EstadoService {
    private final EstadoRepo estadoRepositorio;

    /**
     * Constructor de la clase EstadoService.
     *
     * @param estadoRepositorio Repositorio de Estados.
     */
    @Autowired
    public EstadoService(EstadoRepo estadoRepositorio) {
        this.estadoRepositorio = estadoRepositorio;
    }

    /**
     * Agrega un nuevo Estado.
     *
     * @param estado El Estado a agregar.
     * @return El Estado agregado.
     */
    public Estado addEstado(Estado estado) {
        return estadoRepositorio.save(estado);
    }

    /**
     * Obtiene todos los Estados.
     *
     * @return Una lista de todos los Estados.
     */
    public List<Estado> findAllEstados() {
        return estadoRepositorio.findAll();
    }

    /**
     * Actualiza un Estado existente.
     *
     * @param estado El Estado a actualizar.
     * @return El Estado actualizado.
     */
    public Estado updateEstado(Estado estado) {
        return estadoRepositorio.save(estado);
    }

    /**
     * Busca un Estado por su identificador.
     *
     * @param id El identificador del Estado.
     * @return El Estado encontrado, o null si no se encuentra.
     */
    public Estado findEstadoById(Long id) {
        return estadoRepositorio.findEstadoById(id);
    }

    /**
     * Elimina un Estado por su identificador.
     *
     * @param id El identificador del Estado a eliminar.
     */
    public void deleteEstadoById(Long id) {
        estadoRepositorio.deleteById(id);
    }

    /**
     * Busca un Estado por su nombre.
     *
     * @param nombre El nombre del Estado.
     * @return El Estado encontrado, o null si no se encuentra.
     */
    public Estado findEstadoByNombre(String nombre) {
        return estadoRepositorio.findEstadoByNombre(nombre);
    }
}
