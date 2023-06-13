package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Evento;
import org.mnotario.angular.repos.EventoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase proporciona servicios relacionados con la entidad Evento.
 */
@Service
public class EventoService {
    private final EventoRepo eventoRepositorio;

    /**
     * Constructor de la clase EventoService.
     *
     * @param eventoRepositorio Repositorio de Eventos.
     */
    @Autowired
    public EventoService(EventoRepo eventoRepositorio) {
        this.eventoRepositorio = eventoRepositorio;
    }

    /**
     * Agrega un nuevo Evento.
     *
     * @param evento El Evento a agregar.
     * @return El Evento agregado.
     */
    public Evento addEvento(Evento evento) {
        return eventoRepositorio.save(evento);
    }

    /**
     * Obtiene todos los Eventos.
     *
     * @return Una lista de todos los Eventos.
     */
    public List<Evento> findAllEventos() {
        return eventoRepositorio.findAll();
    }

    /**
     * Actualiza un Evento existente.
     *
     * @param evento El Evento a actualizar.
     * @return El Evento actualizado.
     */
    public Evento updateEvento(Evento evento) {
        return eventoRepositorio.save(evento);
    }

    /**
     * Busca un Evento por su identificador.
     *
     * @param id El identificador del Evento.
     * @return El Evento encontrado, o null si no se encuentra.
     */
    public Evento findEventoById(Long id) {
        return eventoRepositorio.findEventoById(id);
    }

    /**
     * Elimina un Evento por su identificador.
     *
     * @param id El identificador del Evento a eliminar.
     */
    public void deleteEventoById(Long id) {
        eventoRepositorio.deleteById(id);
    }

    /**
     * Busca un Evento por su nombre.
     *
     * @param nombre El nombre del Evento.
     * @return El Evento encontrado, o null si no se encuentra.
     */
    public Evento findEventoByNombre(String nombre) {
        return eventoRepositorio.findEventoByNombre(nombre);
    }
}
