package com.tradeapp.entrypoints.mapper;

import java.util.Optional;

import com.tradeapp.core.enums.UserTypeEnum;
import com.tradeapp.entrypoints.enums.UserTypeHttpModelEnum;

public class UserTypeHttpModelMapper {

	public static UserTypeHttpModelEnum from(UserTypeEnum userTypeEnum) {
		return Optional.ofNullable(userTypeEnum).map(UserTypeEnum::name).map(UserTypeHttpModelEnum::valueOf)
				.orElse(null);
	}

	public static UserTypeEnum to(UserTypeHttpModelEnum userTypeEnum) {
		return Optional.ofNullable(userTypeEnum).map(UserTypeHttpModelEnum::name).map(UserTypeEnum::valueOf)
				.orElse(null);
	}

}
