package com.eu.favorite.service;

import com.eu.favorite.error.NotFoundException;
import com.eu.favorite.model.Category;
import com.eu.favorite.model.User;
import com.eu.favorite.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }


    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    public boolean isAllowedToDelete(long categoryId, User loggedInUser) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Category inDB = category.get();
            return inDB.getUser().getId() == loggedInUser.getId();
        }
        return false;
    }

    public Category getById(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        throw new NotFoundException("category not found:" + id);
    }

}
