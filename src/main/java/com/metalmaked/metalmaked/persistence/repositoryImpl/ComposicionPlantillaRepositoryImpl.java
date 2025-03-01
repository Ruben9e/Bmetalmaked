package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.ComposicionPlantillaDTO;
import com.metalmaked.metalmaked.domain.repository.ComposicionPlantillaRepository;
import com.metalmaked.metalmaked.persistence.crud.ComposicionPlantillaCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.ComposicionPlantilla;
import com.metalmaked.metalmaked.persistence.mapper.ComposicionPlantillaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ComposicionPlantillaRepositoryImpl implements ComposicionPlantillaRepository {

    @Autowired
    private ComposicionPlantillaCrudRepository composicionPlantillaCrudRepository;

    @Autowired
    private ComposicionPlantillaMapper composicionPlantillaMapper;

    @Override
    public Iterable<ComposicionPlantillaDTO> findAll() {
        List<ComposicionPlantilla> composicionPlantillaList = (List<ComposicionPlantilla>) composicionPlantillaCrudRepository.findAll();
        return composicionPlantillaList.stream()
                .map(composicionPlantillaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ComposicionPlantillaDTO> findById(Integer id) {
        return composicionPlantillaCrudRepository.findById(id)
                .map(composicionPlantillaMapper::toDto);
    }

    @Override
    public ComposicionPlantillaDTO save(ComposicionPlantillaDTO composicionPlantillaDTO) {
        ComposicionPlantilla composicionPlantilla = composicionPlantillaMapper.toEntity(composicionPlantillaDTO);
        ComposicionPlantilla savedComposicionPlantilla = composicionPlantillaCrudRepository.save(composicionPlantilla);
        return composicionPlantillaMapper.toDto(savedComposicionPlantilla);
    }

    @Override
    public ComposicionPlantillaDTO update(ComposicionPlantillaDTO composicionPlantillaDTO) {
        if (existsById(composicionPlantillaDTO.getIdPlantilla())) {
            ComposicionPlantilla composicionPlantilla = composicionPlantillaMapper.toEntity(composicionPlantillaDTO);
            ComposicionPlantilla updatedComposicionPlantilla = composicionPlantillaCrudRepository.save(composicionPlantilla);
            return composicionPlantillaMapper.toDto(updatedComposicionPlantilla);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            composicionPlantillaCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return composicionPlantillaCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return composicionPlantillaCrudRepository.count();
    }
}
