package com.eu.favorite.enumaration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class ImportanceLevelEnumConverter implements AttributeConverter<ImportanceLevelEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ImportanceLevelEnum value) {
        return value != null ? value.getLevel() : null;
    }

    @Override
    public ImportanceLevelEnum convertToEntityAttribute(Integer value) {
        if (value == null) {
            return null;
        }
        switch (value) {
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
