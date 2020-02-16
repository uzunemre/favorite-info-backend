package com.eu.favorite.category;

import com.eu.favorite.user.User;
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

    Category save(Category category) {
        return categoryRepository.save(category);
    }

    List<Category> getCategories() {
        return categoryRepository.findAll();
    }


    void deleteCategory(long id) {
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

}
