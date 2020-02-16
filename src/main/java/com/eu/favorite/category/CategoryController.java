package com.eu.favorite.category;

import com.eu.favorite.category.dto.CategoryRequest;
import com.eu.favorite.category.dto.CategoryResponse;
import com.eu.favorite.shared.CurrentUser;
import com.eu.favorite.shared.GenericResponse;
import com.eu.favorite.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/1.0")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        List<Category> categories = categoryService.getCategories();
        List<CategoryResponse> response = categories.stream()
                .map(CategoryResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }


    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryRequest request, @CurrentUser User loggedInUser) {
        Category category = new Category();
        category.setName(request.getName());
        category.setUser(loggedInUser);
        categoryService.save(category);
        return ResponseEntity.ok(new GenericResponse("Category saved"));
    }

    @DeleteMapping("/categories/{id:[0-9]+}")
    @PreAuthorize("@categoryService.isAllowedToDelete(#id, principal)")
    GenericResponse deleteCategory(@PathVariable long id) {
        categoryService.deleteCategory(id);
        return new GenericResponse("Category is removed");
    }


}
