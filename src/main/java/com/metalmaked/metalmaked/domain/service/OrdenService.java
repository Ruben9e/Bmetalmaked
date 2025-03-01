package com.metalmaked.metalmaked.domain.service;

import com.metalmaked.metalmaked.domain.dto.OrdenDTO;
import com.metalmaked.metalmaked.domain.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public Iterable<OrdenDTO> findAll() {
        return ordenRepository.findAll();
    }

    public Optional<OrdenDTO> findById(Integer id) {
        return ordenRepository.findById(id);
    }

    public OrdenDTO save(OrdenDTO ordenDTO) {
        return ordenRepository.save(ordenDTO);
    }

    public OrdenDTO update(OrdenDTO ordenDTO) {
        return ordenRepository.update(ordenDTO);
    }

    public void delete(Integer id) {
        ordenRepository.delete(id);
    }
}
