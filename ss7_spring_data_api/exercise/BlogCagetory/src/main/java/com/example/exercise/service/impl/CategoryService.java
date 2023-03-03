package com.example.exercise.service.impl;

import com.example.exercise.model.Category;
import com.example.exercise.repository.ICategoryRepository;
import com.example.exercise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository cagetoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return cagetoryRepository.findAll();
    }
}
