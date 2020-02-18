package com.eu.favorite.dto;

import com.eu.favorite.model.Category;
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
