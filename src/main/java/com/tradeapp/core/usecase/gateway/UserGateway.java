package com.tradeapp.core.usecase.gateway;

import com.tradeapp.core.model.UserEntity;

public interface UserGateway {

	UserEntity createUser(UserEntity userEntity);

}
