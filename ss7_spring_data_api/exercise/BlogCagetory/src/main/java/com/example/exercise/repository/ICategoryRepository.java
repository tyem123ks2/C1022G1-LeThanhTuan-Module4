package com.example.exercise.repository;

import com.example.exercise.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer>{
//    Page<Category> findByNameCategory(String name, Pageable pageable);
}
