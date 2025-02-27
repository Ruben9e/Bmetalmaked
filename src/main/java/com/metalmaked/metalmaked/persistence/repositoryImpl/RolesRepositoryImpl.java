package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.RolesDTO;
import com.metalmaked.metalmaked.domain.repository.RolesRepository;
import com.metalmaked.metalmaked.persistence.crud.RolesCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.Roles;
import com.metalmaked.metalmaked.persistence.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RolesRepositoryImpl implements RolesRepository {

    @Autowired
    private RolesCrudRepository rolesCrudRepository;

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public Iterable<RolesDTO> findAll() {
        List<Roles> rolesList = (List<Roles>) rolesCrudRepository.findAll();
        return rolesList.stream().map(rolesMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<RolesDTO> findById(Integer id) {
        return rolesCrudRepository.findById(id).map(rolesMapper::toDto);
    }

    @Override
    public RolesDTO save(RolesDTO rolesDTO) {
        Roles roles = rolesMapper.toEntity(rolesDTO);
        if (!existsById(roles.getIdRol())) {
            Roles savedRoles = rolesCrudRepository.save(roles);
            return rolesMapper.toDto(savedRoles);
        }
        throw new IllegalArgumentException("El registro ya existe");
    }

    @Override
    public RolesDTO update(RolesDTO rolesDTO) {
        Roles roles = rolesMapper.toEntity(rolesDTO);
        if (existsById(roles.getIdRol())) {
            Roles updatedRoles = rolesCrudRepository.save(roles);
            return rolesMapper.toDto(updatedRoles);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            rolesCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return rolesCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return rolesCrudRepository.count();
    }
}
