package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Usuario;
import org.mnotario.angular.repos.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	private final UsuarioRepo usuarioRepositorio;

	@Autowired
	public UsuarioService(UsuarioRepo usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	public List<Usuario> findAllUsuarios(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	public Usuario findUsuarioById(Long id) {
		return usuarioRepositorio.findUsuarioById(id);
	}
	
	public void deleteUsuarioById(Long id) {
		usuarioRepositorio.deleteById(id);
	}
}
