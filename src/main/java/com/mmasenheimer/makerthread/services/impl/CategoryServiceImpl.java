package com.mmasenheimer.makerthread.services.impl;

import com.mmasenheimer.makerthread.domain.entities.Category;
import com.mmasenheimer.makerthread.repositories.CategoryRepository;
import com.mmasenheimer.makerthread.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        if(categoryRepository.existsByNameIgnoreCase(category.getName())) {
            // Category with the same name already exists
            String categoryName = category.getName();
            throw new IllegalArgumentException("Category already exists with name: " + categoryName);
        }

        return categoryRepository.save(category);
    }

}
