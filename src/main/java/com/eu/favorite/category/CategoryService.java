package com.eu.favorite.category;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    Category save(Category category) {
        return categoryRepository.save(category);
    }

    List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
