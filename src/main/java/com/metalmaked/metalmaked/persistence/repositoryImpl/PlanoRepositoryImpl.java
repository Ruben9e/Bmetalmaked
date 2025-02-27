package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.PlanoDTO;
import com.metalmaked.metalmaked.domain.repository.PlanoRepository;
import com.metalmaked.metalmaked.persistence.crud.PlanoCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.Plano;
import com.metalmaked.metalmaked.persistence.mapper.PlanoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PlanoRepositoryImpl implements PlanoRepository {

    @Autowired
    private PlanoCrudRepository planoCrudRepository;

    @Autowired
    private PlanoMapper planoMapper;

    @Override
    public Iterable<PlanoDTO> findAll() {
        List<Plano> planos = (List<Plano>) planoCrudRepository.findAll();
        return planos.stream().map(planoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PlanoDTO> findById(Integer id) {
        return planoCrudRepository.findById(id).map(planoMapper::toDto);
    }

    @Override
    public PlanoDTO save(PlanoDTO planoDTO) {
        Plano plano = planoMapper.toEntity(planoDTO);
        if (!existsById(plano.getIdPlano())) {
            Plano savedPlano = planoCrudRepository.save(plano);
            return planoMapper.toDto(savedPlano);
        }
        throw new IllegalArgumentException("El registro ya existe");
    }

    @Override
    public PlanoDTO update(PlanoDTO planoDTO) {
        Plano plano = planoMapper.toEntity(planoDTO);
        if (existsById(plano.getIdPlano())) {
            Plano updatedPlano = planoCrudRepository.save(plano);
            return planoMapper.toDto(updatedPlano);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            planoCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return planoCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return planoCrudRepository.count();
    }
}
