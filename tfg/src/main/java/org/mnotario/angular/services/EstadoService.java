package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Estado;
import org.mnotario.angular.repos.EstadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
	private final EstadoRepo EstadoRepositorio;

	@Autowired
	public EstadoService(EstadoRepo EstadoRepositorio) {
		super();
		this.EstadoRepositorio = EstadoRepositorio;
	}
	
	public Estado addEstado(Estado Estado) {
		return EstadoRepositorio.save(Estado);
	}
	
	public List<Estado> findAllEstados(){
		return EstadoRepositorio.findAll();
	}
	
	public Estado updateEstado(Estado Estado) {
		return EstadoRepositorio.save(Estado);
	}
	
	public Estado findEstadoById(Long id) {
		return EstadoRepositorio.findEstadoById(id);
	}
	
	public void deleteEstadoById(Long id) {
		EstadoRepositorio.deleteById(id);
	}
	
	

}
