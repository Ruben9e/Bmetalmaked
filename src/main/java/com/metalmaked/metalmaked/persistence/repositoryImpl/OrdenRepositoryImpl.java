package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.OrdenDTO;
import com.metalmaked.metalmaked.domain.repository.OrdenRepository;
import com.metalmaked.metalmaked.persistence.crud.OrdenCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.Orden;
import com.metalmaked.metalmaked.persistence.mapper.OrdenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrdenRepositoryImpl implements OrdenRepository {

    @Autowired
    private OrdenCrudRepository ordenCrudRepository;

    @Autowired
    private OrdenMapper ordenMapper;

    @Override
    public Iterable<OrdenDTO> findAll() {
        List<Orden> ordenList = (List<Orden>) ordenCrudRepository.findAll();
        return ordenList.stream().map(ordenMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<OrdenDTO> findById(Integer id) {
        return ordenCrudRepository.findById(id).map(ordenMapper::toDto);
    }

    @Override
    public OrdenDTO save(OrdenDTO ordenDTO) {
        Orden orden = ordenMapper.toEntity(ordenDTO);
        Orden savedOrden = ordenCrudRepository.save(orden);
        return ordenMapper.toDto(savedOrden);
    }

    @Override
    public OrdenDTO update(OrdenDTO ordenDTO) {
        if (existsById(ordenDTO.getIdOrden())) {
            Orden orden = ordenMapper.toEntity(ordenDTO);
            Orden updatedOrden = ordenCrudRepository.save(orden);
            return ordenMapper.toDto(updatedOrden);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            ordenCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return ordenCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return ordenCrudRepository.count();
    }
}
