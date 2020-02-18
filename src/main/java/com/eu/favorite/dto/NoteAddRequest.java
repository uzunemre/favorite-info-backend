package com.eu.favorite.dto;

import com.eu.favorite.enumaration.ImportanceLevelEnum;
import com.eu.favorite.enumaration.ImportanceLevelEnumConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
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
    @Convert(converter = ImportanceLevelEnumConverter.class)
    private ImportanceLevelEnum importanceLevel;

    private boolean read = false;

}
