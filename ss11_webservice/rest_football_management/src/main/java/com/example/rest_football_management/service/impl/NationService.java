package com.example.rest_football_management.service.impl;

import com.example.rest_football_management.model.Nation;
import com.example.rest_football_management.repository.INationRepository;
import com.example.rest_football_management.service.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService implements INationService {
    @Autowired
    private INationRepository nationRepository;

    @Override
    public List<Nation> getAllNation() {
        return nationRepository.findAll();
    }
}
