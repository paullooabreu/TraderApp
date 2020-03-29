package com.tradeapp.core.usecase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		validaUser(userEntity);
		userEntity.setUserType(UserTypeEnum.SIMPLE);
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

	public void validaUser(UserEntity entity) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);

		if (entity == null) {
			throw new BusinnesException(MessageUtil.CREATE_USER_ERROR);
		}

		Matcher matcher = pattern.matcher(entity.getEmail());

		if (entity.getName().equals(null) || entity.getName().isEmpty()) {
			throw new BusinnesException(MessageUtil.USER_NAME_ERROR);
		} else if (!matcher.matches()) {
			throw new BusinnesException(MessageUtil.USER_EMAIL_ERROR);
		} else if (entity.getPassword().length() <= 5) {
			throw new BusinnesException(MessageUtil.USER_PASSWORD_ERROR);
		}
	}
}
