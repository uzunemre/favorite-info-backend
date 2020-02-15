package com.eu.favorite.category.dto;

import com.eu.favorite.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryResponse {

    private long id;

    private String name;

    public CategoryResponse(Category category) {
        this.setId(category.getId());
        this.setName(category.getName());
    }

}
