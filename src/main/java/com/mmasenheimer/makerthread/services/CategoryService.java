package com.mmasenheimer.makerthread.services;

import com.mmasenheimer.makerthread.domain.entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listCategories();

    Category createCategory(Category category);
}
