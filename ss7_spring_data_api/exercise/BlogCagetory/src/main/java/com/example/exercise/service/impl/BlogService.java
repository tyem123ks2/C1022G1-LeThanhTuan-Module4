package com.example.exercise.service.impl;

import com.example.exercise.model.Blog;
import com.example.exercise.repository.IBlogRepository;
import com.example.exercise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> searchTitle(String title, Pageable pageable) {
        return blogRepository.searchTitle(title, pageable);
    }

    @Override
    public Page<Blog> findBlogByCategory(int id, Pageable pageable) {
        return blogRepository.findBlogByCategory(id, pageable);
    }

    @Override
    public List<Blog> findBlogByCategory(int id) {
        return blogRepository.findBlogByCategory(id);
    }

    @Override
    public boolean addNewBlog(Blog blog) {
        try {
            if (blogRepository.findByTitle(blog.getTitle()) != null) {
                throw new SQLDataException();
            }
            blogRepository.save(blog);
        } catch (IllegalArgumentException | OptimisticLockingFailureException | SQLDataException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        if (!blogRepository.existsById(blog.getId())) {
            return false;
        }
        try {
            blogRepository.save(blog);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeBlog(int id) {
        try {
            blogRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    @Override
    public Optional<Blog> findBlogById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

}
