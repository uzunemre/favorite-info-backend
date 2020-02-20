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
        return ImportanceLevelEnum.getImportanceLevel(value);
    }
}
