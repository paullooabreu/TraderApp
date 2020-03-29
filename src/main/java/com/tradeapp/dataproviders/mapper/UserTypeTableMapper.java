package com.tradeapp.dataproviders.mapper;

import java.util.Optional;

import com.tradeapp.core.enums.UserTypeEnum;
import com.tradeapp.dataproviders.enums.UserTypeTableEnum;

public class UserTypeTableMapper {

	public static UserTypeTableEnum from(UserTypeEnum userTypeEnum) {
		return Optional.ofNullable(userTypeEnum).map(UserTypeEnum::name).map(UserTypeTableEnum::valueOf).orElse(null);
	}

	public static UserTypeEnum to(UserTypeTableEnum userTypeEnum) {
		return Optional.ofNullable(userTypeEnum).map(UserTypeTableEnum::name).map(UserTypeEnum::valueOf).orElse(null);
	}

}
