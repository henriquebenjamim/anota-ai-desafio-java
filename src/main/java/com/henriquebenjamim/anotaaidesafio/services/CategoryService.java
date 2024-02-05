package com.henriquebenjamim.anotaaidesafio.services;

import com.henriquebenjamim.anotaaidesafio.domain.category.Category;
import com.henriquebenjamim.anotaaidesafio.domain.category.CategoryDTO;
import com.henriquebenjamim.anotaaidesafio.domain.category.exceptions.CategoryNotFoundException;
import com.henriquebenjamim.anotaaidesafio.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    private CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category insert(CategoryDTO categoryData) {
        Category newCategory = new Category(categoryData);
        this.categoryRepository.save(newCategory);
        return newCategory;
    }

    public Category update(String id, CategoryDTO categoryData) {
        Category category = this.categoryRepository
                .findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        if(!categoryData.title().isEmpty()) category.setTitle(categoryData.title());
        if(!categoryData.description().isEmpty()) category.setDescription(categoryData.description());

        this.categoryRepository.save(category);
        return category;
    }

    public void delete(String id) {
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        this.categoryRepository.delete(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
