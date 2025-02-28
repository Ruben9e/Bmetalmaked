package com.metalmaked.metalmaked.persistence.repositoryImpl;

import com.metalmaked.metalmaked.domain.dto.MaterialDTO;
import com.metalmaked.metalmaked.domain.repository.MaterialRepository;
import com.metalmaked.metalmaked.persistence.crud.MaterialCrudRepository;
import com.metalmaked.metalmaked.persistence.entity.Material;
import com.metalmaked.metalmaked.persistence.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MaterialRepositoryImpl implements MaterialRepository {

    @Autowired
    private MaterialCrudRepository materialCrudRepository;

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public Iterable<MaterialDTO> findAll() {
        List<Material> materialList = (List<Material>) materialCrudRepository.findAll();
        return materialList.stream().map(materialMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<MaterialDTO> findById(Integer id) {
        return materialCrudRepository.findById(id).map(materialMapper::toDto);
    }

    @Override
    public MaterialDTO save(MaterialDTO materialDTO) {
        Material material = materialMapper.toEntity(materialDTO);
        Material savedMaterial = materialCrudRepository.save(material);
        return materialMapper.toDto(savedMaterial);
    }

    @Override
    public MaterialDTO update(MaterialDTO materialDTO) {
        if (existsById(materialDTO.getIdMaterial())) {
            Material material = materialMapper.toEntity(materialDTO);
            Material updatedMaterial = materialCrudRepository.save(material);
            return materialMapper.toDto(updatedMaterial);
        }
        throw new IllegalArgumentException("El registro no existe");
    }

    @Override
    public void delete(Integer id) {
        if (existsById(id)) {
            materialCrudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El registro no existe");
        }
    }

    @Override
    public boolean existsById(Integer id) {
        return materialCrudRepository.existsById(id);
    }

    @Override
    public long count() {
        return materialCrudRepository.count();
    }
}
