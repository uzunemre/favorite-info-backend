package com.eu.favorite.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CategoryAddRequest {

    @NotNull
    @Size(min = 2, max = 255)
    private String name;

}
