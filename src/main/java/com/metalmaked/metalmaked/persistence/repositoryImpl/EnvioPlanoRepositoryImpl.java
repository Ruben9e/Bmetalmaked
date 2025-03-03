package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.EnvioPlanoDTO;
import com.metalmaked.metalmaked.domain.repository.EnvioPlanoRepository;
import com.metalmaked.metalmaked.persistence.crud.EnvioPlanoCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.EnvioPlano;
import com.metalmaked.metalmaked.persistence.mapper.EnvioPlanoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EnvioPlanoRepositoryImpl implements EnvioPlanoRepository {

    @Autowired
    private EnvioPlanoCrudRepository envioPlanoCrudRepository;

    @Autowired
    private EnvioPlanoMapper envioPlanoMapper;

    @Override
    public Iterable<EnvioPlanoDTO> findAll() {
        List<EnvioPlano> envioPlanoList = (List<EnvioPlano>) envioPlanoCrudRepository.findAll();
        return envioPlanoList.stream().map(envioPlanoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<EnvioPlanoDTO> findById(Integer idOrden, Integer idPlano) {
        return envioPlanoCrudRepository.findByIdOrdenAndIdPlano(idOrden, idPlano)
                .map(envioPlanoMapper::toDto);
    }

    @Override
    public EnvioPlanoDTO save(EnvioPlanoDTO envioPlanoDTO) {
        EnvioPlano envioPlano = envioPlanoMapper.toEntity(envioPlanoDTO);
        EnvioPlano savedEnvioPlano = envioPlanoCrudRepository.save(envioPlano);
        return envioPlanoMapper.toDto(savedEnvioPlano);
    }

    @Override
    public EnvioPlanoDTO update(EnvioPlanoDTO envioPlanoDTO) {
        if (existsById(envioPlanoDTO.getIdOrden(), envioPlanoDTO.getIdPlano())) {
            EnvioPlano envioPlano = envioPlanoMapper.toEntity(envioPlanoDTO);
            EnvioPlano updatedEnvioPlano = envioPlanoCrudRepository.save(envioPlano);
            return envioPlanoMapper.toDto(updatedEnvioPlano);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer idOrden, Integer idPlano) {
        if (existsById(idOrden, idPlano)) {
            envioPlanoCrudRepository.deleteByIdOrdenAndIdPlano(idOrden, idPlano);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer idOrden, Integer idPlano) {
        return envioPlanoCrudRepository.existsByIdOrdenAndIdPlano(idOrden, idPlano);
    }

    @Override
    public long count() {
        return envioPlanoCrudRepository.count();
    }
}
