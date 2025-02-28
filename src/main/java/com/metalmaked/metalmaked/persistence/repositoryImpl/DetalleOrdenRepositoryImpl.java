package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.DetalleOrdenDTO;
import com.metalmaked.metalmaked.domain.repository.DetalleOrdenRepository;
import com.metalmaked.metalmaked.persistence.crud.DetalleOrdenCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.DetalleOrden;
import com.metalmaked.metalmaked.persistence.mapper.DetalleOrdenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DetalleOrdenRepositoryImpl implements DetalleOrdenRepository {

    @Autowired
    private DetalleOrdenCrudRepository detalleOrdenCrudRepository;

    @Autowired
    private DetalleOrdenMapper detalleOrdenMapper;

    @Override
    public Iterable<DetalleOrdenDTO> findAll() {
        List<DetalleOrden> detalleOrdenList = (List<DetalleOrden>) detalleOrdenCrudRepository.findAll();
        return detalleOrdenList.stream().map(detalleOrdenMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<DetalleOrdenDTO> findById(Integer id) {
        return detalleOrdenCrudRepository.findById(id).map(detalleOrdenMapper::toDto);
    }

    @Override
    public DetalleOrdenDTO save(DetalleOrdenDTO detalleOrdenDTO) {
        DetalleOrden detalleOrden = detalleOrdenMapper.toEntity(detalleOrdenDTO);
        DetalleOrden savedDetalleOrden = detalleOrdenCrudRepository.save(detalleOrden);
        return detalleOrdenMapper.toDto(savedDetalleOrden);
    }

    @Override
    public DetalleOrdenDTO update(DetalleOrdenDTO detalleOrdenDTO) {
        if (existsById(detalleOrdenDTO.getIdDetalle())) {
            DetalleOrden detalleOrden = detalleOrdenMapper.toEntity(detalleOrdenDTO);
            DetalleOrden updatedDetalleOrden = detalleOrdenCrudRepository.save(detalleOrden);
            return detalleOrdenMapper.toDto(updatedDetalleOrden);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            detalleOrdenCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return detalleOrdenCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return detalleOrdenCrudRepository.count();
    }
}
