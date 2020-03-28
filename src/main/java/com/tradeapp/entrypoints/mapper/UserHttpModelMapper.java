package com.tradeapp.entrypoints.mapper;

import org.springframework.stereotype.Component;

import com.tradeapp.core.model.UserEntity;
import com.tradeapp.entrypoints.model.UserHttpModel;
import com.tradeapp.service.util.mapper.FromToMapper;

@Component
public class UserHttpModelMapper extends FromToMapper<UserHttpModel, UserEntity> {

	@Override
	protected UserHttpModel fromNonNull(UserEntity entity) {
		return UserHttpModel.builder().cod(entity.getCod())
				.name(entity.getName())
				.email(entity.getEmail())
				.userType(UserTypeHttpModelMapper.from(entity.getUserType())).build();
	}

	@Override
	protected UserEntity toNonNull(UserHttpModel entity) {
		return UserEntity.builder().cod(entity.getCod())
				.name(entity.getName())
				.email(entity.getEmail())
				.userType(UserTypeHttpModelMapper.to(entity.getUserType())).password(entity.getPassword()).build();
	}

}
