package com.eu.favorite.enumaration;

import lombok.Getter;

@Getter
public enum ImportanceLevelEnum {

    VERY_LOW(1, "Very Low"),
    LOW(2, "Low"),
    MEDIUM(3, "Medium"),
    HIGH(4, "High"),
    VERY_HIGH(5, "Very High");

    private Integer level;
    private String label;

    ImportanceLevelEnum(Integer level, String label) {
        this.level = level;
        this.label = label;
    }

}
