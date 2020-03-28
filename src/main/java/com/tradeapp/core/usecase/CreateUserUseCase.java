package com.tradeapp.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.tradeapp.core.enums.UserTypeEnum;
import com.tradeapp.core.model.UserEntity;
import com.tradeapp.core.usecase.gateway.UserGateway;
import com.tradeapp.service.util.mapper.exception.BusinnesException;
import com.tradeapp.util.MessageUtil;

@Component
public class CreateUserUseCase {

	@Autowired
	private UserGateway userGateway;

	public UserEntity createUser(UserEntity userEntity) {
		UserEntity entityResult;

		userEntity.setUserType(UserTypeEnum.ADMINISTRATOR);
		userEntity.setPassword(passwordEncoder(userEntity));

		try {
			entityResult = userGateway.createUser(userEntity);
		} catch (Exception e) {
			throw new BusinnesException(MessageUtil.CREATE_USER_ERROR);
		}
		return entityResult;
	}

	private String passwordEncoder(UserEntity userEntity) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(userEntity.getPassword());
	}

}
