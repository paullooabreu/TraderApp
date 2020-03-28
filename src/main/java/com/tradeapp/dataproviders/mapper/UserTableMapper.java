package com.tradeapp.dataproviders.mapper;

import org.springframework.stereotype.Component;

import com.tradeapp.core.model.UserEntity;
import com.tradeapp.dataproviders.models.UserTable;
import com.tradeapp.entrypoints.model.UserTypeTableMapper;
import com.tradeapp.service.util.mapper.FromToMapper;

@Component
public class UserTableMapper extends FromToMapper<UserTable, UserEntity> {

	@Override
	protected UserTable fromNonNull(UserEntity entity) {
		return UserTable.builder().cod(entity.getCod()).email(entity.getEmail()).name(entity.getName())
				.password(entity.getPassword())
				.userType(UserTypeTableMapper.from(entity.getUserType())).build();
	}

	@Override
	protected UserEntity toNonNull(UserTable entity) {
		return UserEntity.builder().cod(entity.getCod()).email(entity.getEmail()).name(entity.getName())
				.userType(UserTypeTableMapper.to(entity.getUserType())).build();
	}

}
