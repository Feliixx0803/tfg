package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Inscripcion;
import org.mnotario.angular.repos.InscripcionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionService {
	private final InscripcionRepo inscripcionRepositorio;

	@Autowired
	public InscripcionService(InscripcionRepo inscripcionRepositorio) {
		super();
		this.inscripcionRepositorio = inscripcionRepositorio;
	}
	
	public Inscripcion addInscripcion(Inscripcion inscripcion) {
		return inscripcionRepositorio.save(inscripcion);
	}
	
	public List<Inscripcion> findAllInscripciones(){
		return inscripcionRepositorio.findAll();
	}
	
	public Inscripcion updateInscripciones(Inscripcion inscripcion) {
		return inscripcionRepositorio.save(inscripcion);
	}
	
	public Inscripcion findInscripcionesById(Long id) {
		return inscripcionRepositorio.findInscripcionById(id);
	}
	
	public void deleteInscripcionById(Long id) {
		inscripcionRepositorio.deleteById(id);
	}
	
}
