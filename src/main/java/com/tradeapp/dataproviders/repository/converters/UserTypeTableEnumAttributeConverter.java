package com.tradeapp.dataproviders.repository.converters;

import java.util.Optional;

import javax.persistence.AttributeConverter;

import com.tradeapp.dataproviders.enums.UserTypeTableEnum;

public class UserTypeTableEnumAttributeConverter implements AttributeConverter<UserTypeTableEnum, Long> {

	@Override
	public Long convertToDatabaseColumn(UserTypeTableEnum attribute) {
		return Optional.ofNullable(attribute).map(UserTypeTableEnum::getCode).orElse(null);
	}

	@Override
	public UserTypeTableEnum convertToEntityAttribute(Long code) {
		return Optional.ofNullable(code).map(UserTypeTableEnum::getByCode).orElse(null);
	}

}
