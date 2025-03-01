package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.RolesDTO;
import com.metalmaked.metalmaked.domain.repository.RolesRepository;
import com.metalmaked.metalmaked.persistence.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private RolesMapper rolesMapper;

    // Consultar todos los registros
    public Iterable<RolesDTO> findAll() {
        return rolesRepository.findAll();
    }

    // Consultar por ID
    public Optional<RolesDTO> findById(Integer id) {
        return rolesRepository.findById(id);
    }

    // Guardar un registro
    public RolesDTO save(RolesDTO rolesDTO) {
        return rolesRepository.save(rolesDTO);
    }

    // Actualizar un registro
    public RolesDTO update(RolesDTO rolesDTO) {
        return rolesRepository.update(rolesDTO);
    }

    // Eliminar un registro
    public void delete(Integer id) {
        rolesRepository.delete(id);
    }

    // Validar si existe por ID
    public boolean existsById(Integer id) {
        return rolesRepository.existsById(id);
    }

    // Contar todos los registros
    public long count() {
        return rolesRepository.count();
    }
}
