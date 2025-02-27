package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.PlantillaDTO;
import com.metalmaked.metalmaked.domain.repository.PlantillaRepository;
import com.metalmaked.metalmaked.persistence.crud.PlantillaCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.Plantilla;
import com.metalmaked.metalmaked.persistence.mapper.PlantillaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PlantillaRepositoryImpl implements PlantillaRepository {

    @Autowired
    private PlantillaCrudRepository plantillaCrudRepository;

    @Autowired
    private PlantillaMapper plantillaMapper;

    @Override
    public Iterable<PlantillaDTO> findAll() {
        List<Plantilla> plantillaList = (List<Plantilla>) plantillaCrudRepository.findAll();
        return plantillaList.stream().map(plantillaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PlantillaDTO> findById(Integer id) {
        return plantillaCrudRepository.findById(id).map(plantillaMapper::toDto);
    }

    @Override
    public PlantillaDTO save(PlantillaDTO plantillaDTO) {
        Plantilla plantilla = plantillaMapper.toEntity(plantillaDTO);
        if (!existsById(plantilla.getIdPlantilla())) {
            Plantilla savedPlantilla = plantillaCrudRepository.save(plantilla);
            return plantillaMapper.toDto(savedPlantilla);
        }
        throw new IllegalArgumentException("El registro ya existe");
    }

    @Override
    public PlantillaDTO update(PlantillaDTO plantillaDTO) {
        Plantilla plantilla = plantillaMapper.toEntity(plantillaDTO);
        if (existsById(plantilla.getIdPlantilla())) {
            Plantilla updatedPlantilla = plantillaCrudRepository.save(plantilla);
            return plantillaMapper.toDto(updatedPlantilla);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            plantillaCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return plantillaCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return plantillaCrudRepository.count();
    }
}
