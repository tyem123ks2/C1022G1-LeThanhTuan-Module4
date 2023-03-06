package com.example.football_management.service.impl;

import com.example.football_management.model.Position;
import com.example.football_management.repository.IPositionRepository;
import com.example.football_management.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }
}
