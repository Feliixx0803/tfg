package org.mnotario.angular.services;

import java.util.List;

import org.mnotario.angular.model.Rol;
import org.mnotario.angular.repos.RolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta clase proporciona servicios relacionados con la entidad Rol.
 */
@Service
public class RolService {

    private final RolRepo rolRepo;

    /**
     * Constructor de la clase RolService.
     *
     * @param rolRepo Repositorio de Roles.
     */
    @Autowired
    public RolService(RolRepo rolRepo) {
        this.rolRepo = rolRepo;
    }

    /**
     * Agrega un nuevo Rol.
     *
     * @param rol El Rol a agregar.
     * @return El Rol agregado.
     */
    public Rol addRol(Rol rol) {
        return rolRepo.save(rol);
    }

    /**
     * Obtiene todos los Roles.
     *
     * @return Una lista de todos los Roles.
     */
    public List<Rol> findAllRoles() {
        return rolRepo.findAll();
    }

    /**
     * Actualiza un Rol existente.
     *
     * @param rol El Rol a actualizar.
     * @return El Rol actualizado.
     */
    public Rol updateRol(Rol rol) {
        return rolRepo.save(rol);
    }

    /**
     * Busca un Rol por su identificador.
     *
     * @param id El identificador del Rol.
     * @return El Rol encontrado, o null si no se encuentra.
     */
    public Rol findRolById(Long id) {
        return rolRepo.findRolById(id);
    }

    /**
     * Elimina un Rol por su identificador.
     *
     * @param id El identificador del Rol a eliminar.
     */
    public void deleteRolById(Long id) {
        rolRepo.deleteById(id);
    }
}
