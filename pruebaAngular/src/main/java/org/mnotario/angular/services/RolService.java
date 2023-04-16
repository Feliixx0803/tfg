package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Rol;
import org.mnotario.angular.repos.RolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

	private final RolRepo rolRepo;
	
	@Autowired
	public RolService(RolRepo rolRepo) {
		super();
		this.rolRepo = rolRepo;
	}
	
	public Rol addRol(Rol rol) {
		return rolRepo.save(rol);
	}
	
	public List<Rol> findAllRoles() {
		return rolRepo.findAll();
	}
	
	public Rol updateRol(Rol rol) {
		return rolRepo.save(rol);
	}
	
	public Rol findRolById(Long id) {
		return rolRepo.findRolById(id);
	}
	
	public void deleteRolById(Long id) {
		rolRepo.deleteById(id);
	}
}
