package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Inscripcion;
import org.mnotario.angular.repos.InscripcionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase proporciona servicios relacionados con la entidad Inscripcion.
 */
@Service
public class InscripcionService {
    private final InscripcionRepo inscripcionRepositorio;

    /**
     * Constructor de la clase InscripcionService.
     *
     * @param inscripcionRepositorio Repositorio de Inscripciones.
     */
    @Autowired
    public InscripcionService(InscripcionRepo inscripcionRepositorio) {
        this.inscripcionRepositorio = inscripcionRepositorio;
    }

    /**
     * Agrega una nueva Inscripcion.
     *
     * @param inscripcion La Inscripcion a agregar.
     * @return La Inscripcion agregada.
     */
    public Inscripcion addInscripcion(Inscripcion inscripcion) {
        return inscripcionRepositorio.save(inscripcion);
    }

    /**
     * Obtiene todas las Inscripciones.
     *
     * @return Una lista de todas las Inscripciones.
     */
    public List<Inscripcion> findAllInscripciones() {
        return inscripcionRepositorio.findAll();
    }

    /**
     * Actualiza una Inscripcion existente.
     *
     * @param inscripcion La Inscripcion a actualizar.
     * @return La Inscripcion actualizada.
     */
    public Inscripcion updateInscripciones(Inscripcion inscripcion) {
        return inscripcionRepositorio.save(inscripcion);
    }

    /**
     * Busca una Inscripcion por su identificador.
     *
     * @param id El identificador de la Inscripcion.
     * @return La Inscripcion encontrada, o null si no se encuentra.
     */
    public Inscripcion findInscripcionesById(Long id) {
        return inscripcionRepositorio.findInscripcionById(id);
    }

    /**
     * Elimina una Inscripcion por su identificador.
     *
     * @param id El identificador de la Inscripcion a eliminar.
     */
    public void deleteInscripcionById(Long id) {
        inscripcionRepositorio.deleteById(id);
    }
}
