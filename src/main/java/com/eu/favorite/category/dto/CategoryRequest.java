package com.eu.favorite.category.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CategoryRequest {

    @NotNull
    @Size(min = 2, max = 255)
    private String name;

}
