package com.tradeapp.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeapp.core.model.UserEntity;
import com.tradeapp.core.usecase.CreateUserUseCase;
import com.tradeapp.entrypoints.mapper.UserHttpModelMapper;
import com.tradeapp.entrypoints.model.UserHttpModel;

@RestController
@RequestMapping("/app/login")
public class UserEntryPoint {

	@Autowired
	UserHttpModelMapper mapper;

	@Autowired
	CreateUserUseCase createUserUserCase;

	@PostMapping(path = "/createUser")
	public ResponseEntity<UserHttpModel> createUser(@RequestBody UserHttpModel userHttpModel) {

		UserEntity userEntity = createUserUserCase.createUser(mapper.to(userHttpModel));

		if (userEntity == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(mapper.from(userEntity));
		}

	}

}
