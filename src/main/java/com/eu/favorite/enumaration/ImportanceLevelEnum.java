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

    public static ImportanceLevelEnum getImportanceLevel(Integer level) {
        if (level == null) {
            return null;
        }
        switch (level) {
            case 1:
                return ImportanceLevelEnum.VERY_LOW;
            case 2:
                return ImportanceLevelEnum.LOW;
            case 3:
                return ImportanceLevelEnum.MEDIUM;
            case 4:
                return ImportanceLevelEnum.HIGH;
            case 5:
                return ImportanceLevelEnum.VERY_HIGH;
            default:
                return null;
        }
    }

}
