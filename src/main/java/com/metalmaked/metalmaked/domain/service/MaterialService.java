package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.MaterialDTO;
import com.metalmaked.metalmaked.domain.repository.MaterialRepository;
import com.metalmaked.metalmaked.persistence.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private MaterialMapper materialMapper;

    // Consultar todos los materiales
    public Iterable<MaterialDTO> findAll() {
        return materialRepository.findAll();
    }

    // Consultar por ID
    public Optional<MaterialDTO> findById(Integer id) {
        return materialRepository.findById(id);
    }

    // Guardar un material
    public MaterialDTO save(MaterialDTO materialDTO) {
        return materialRepository.save(materialDTO);
    }

    // Actualizar un material
    public MaterialDTO update(MaterialDTO materialDTO) {
        return materialRepository.update(materialDTO);
    }

    // Eliminar un material
    public void delete(Integer id) {
        materialRepository.delete(id);
    }

    // Validar si existe por ID
    public boolean existsById(Integer id) {
        return materialRepository.existsById(id);
    }

    // Contar todos los materiales
    public long count() {
        return materialRepository.count();
    }
}
