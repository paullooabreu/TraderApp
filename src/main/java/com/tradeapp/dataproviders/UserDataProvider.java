package com.tradeapp.dataproviders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeapp.core.model.UserEntity;
import com.tradeapp.core.usecase.gateway.UserGateway;
import com.tradeapp.dataproviders.mapper.UserTableMapper;
import com.tradeapp.dataproviders.models.UserTable;
import com.tradeapp.dataproviders.repository.UserRepository;
import com.tradeapp.service.util.mapper.exception.ServiceUnavailableException;
import com.tradeapp.util.MessageUtil;

@Component
public class UserDataProvider implements UserGateway {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	UserTableMapper mapper;

	@Override
	public UserEntity createUser(UserEntity userEntity) {
		UserTable userTableResult;

		try {
			userTableResult = userRepository.save(mapper.from(userEntity));
		} catch (Exception e) {
			throw new ServiceUnavailableException(MessageUtil.CREATE_USER_ERROR);
		}

		return Optional.of(userTableResult).map(userResult -> mapper.to(userResult)).orElse(null);
	}

}
