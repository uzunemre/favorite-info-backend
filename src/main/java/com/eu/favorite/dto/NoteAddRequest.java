package com.eu.favorite.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class NoteAddRequest {

    @NotNull
    @Size(min = 2, max = 255)
    private String title;

    @NotNull
    private String content;

    private String summary; // not required

    @NotNull
    private Integer categoryId;

    @NotNull
    private Integer importanceLevel;

    private boolean read = false;

}
