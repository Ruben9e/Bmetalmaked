package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.PlanoDTO;
import com.metalmaked.metalmaked.domain.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    // Consultar todos los planos
    public Iterable<PlanoDTO> findAll() {
        return planoRepository.findAll();
    }

    // Consultar plano por ID
    public Optional<PlanoDTO> findById(Integer id) {
        return planoRepository.findById(id);
    }

    // Guardar un nuevo plano
    public PlanoDTO save(PlanoDTO planoDTO) {
        return planoRepository.save(planoDTO);
    }

    // Actualizar un plano existente
    public PlanoDTO update(PlanoDTO planoDTO) {
        return planoRepository.update(planoDTO);
    }

    // Eliminar un plano por ID
    public void delete(Integer id) {
        planoRepository.delete(id);
    }

    // Verificar si existe un plano por ID
    public boolean existsById(Integer id) {
        return planoRepository.existsById(id);
    }

    // Contar el número total de planos
    public long count() {
        return planoRepository.count();
    }
}
