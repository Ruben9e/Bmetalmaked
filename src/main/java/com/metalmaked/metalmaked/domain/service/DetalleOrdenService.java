package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.DetalleOrdenDTO;
import com.metalmaked.metalmaked.domain.repository.DetalleOrdenRepository;
import com.metalmaked.metalmaked.persistence.mapper.DetalleOrdenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Autowired
    private DetalleOrdenMapper detalleOrdenMapper;

    // Consultar todos los detalles de órdenes
    public Iterable<DetalleOrdenDTO> findAll() {
        return detalleOrdenRepository.findAll();
    }

    // Consultar detalle de orden por ID
    public Optional<DetalleOrdenDTO> findById(Integer idDetalle) {
        return detalleOrdenRepository.findById(idDetalle);
    }

    // Guardar un nuevo detalle de orden
    public DetalleOrdenDTO save(DetalleOrdenDTO detalleOrdenDTO) {
        return detalleOrdenRepository.save(detalleOrdenDTO);
    }

    // Actualizar un detalle de orden existente
    public DetalleOrdenDTO update(DetalleOrdenDTO detalleOrdenDTO) {
        return detalleOrdenRepository.update(detalleOrdenDTO);
    }

    // Eliminar un detalle de orden
    public void delete(Integer idDetalle) {
        detalleOrdenRepository.delete(idDetalle);
    }

    // Validar si existe por ID
    public boolean existsById(Integer idDetalle) {
        return detalleOrdenRepository.existsById(idDetalle);
    }

    // Contar todos los registros de detalles de órdenes
    public long count() {
        return detalleOrdenRepository.count();
    }
}
