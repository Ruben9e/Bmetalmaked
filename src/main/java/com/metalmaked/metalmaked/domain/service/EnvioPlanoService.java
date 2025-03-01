package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.EnvioPlanoDTO;
import com.metalmaked.metalmaked.domain.repository.EnvioPlanoRepository;
import com.metalmaked.metalmaked.persistence.mapper.EnvioPlanoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnvioPlanoService {

    @Autowired
    private EnvioPlanoRepository envioPlanoRepository;

    @Autowired
    private EnvioPlanoMapper envioPlanoMapper;

    // Consultar todos los envíos de planos
    public Iterable<EnvioPlanoDTO> findAll() {
        return envioPlanoRepository.findAll();
    }

    // Consultar por ID de orden y plano
    public Optional<EnvioPlanoDTO> findById(Integer idOrden, Integer idPlano) {
        return envioPlanoRepository.findById(idOrden, idPlano);
    }

    // Guardar un nuevo envío de plano
    public EnvioPlanoDTO save(EnvioPlanoDTO envioPlanoDTO) {
        return envioPlanoRepository.save(envioPlanoDTO);
    }

    // Actualizar un envío de plano
    public EnvioPlanoDTO update(EnvioPlanoDTO envioPlanoDTO) {
        return envioPlanoRepository.update(envioPlanoDTO);
    }

    // Eliminar un envío de plano
    public void delete(Integer idOrden, Integer idPlano) {
        envioPlanoRepository.delete(idOrden, idPlano);
    }

    // Validar si existe por ID de orden y plano
    public boolean existsById(Integer idOrden, Integer idPlano) {
        return envioPlanoRepository.existsById(idOrden, idPlano);
    }

    // Contar todos los registros de envíos de planos
    public long count() {
        return envioPlanoRepository.count();
    }
}
