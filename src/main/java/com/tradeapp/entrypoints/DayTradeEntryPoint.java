package com.tradeapp.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeapp.core.model.DayTradeEntity;
import com.tradeapp.core.usecase.CreateDayTradeUseCase;
import com.tradeapp.entrypoints.mapper.DayTradeHttpModelMapper;
import com.tradeapp.entrypoints.model.DayTradeHttpModel;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/app/logged")
public class DayTradeEntryPoint {

	@Autowired
	DayTradeHttpModelMapper mapper;

	@Autowired
	CreateDayTradeUseCase createDayTradeUseCase;

	@ApiOperation(value = "Cria um novo dia de trader")
	@ApiResponse(code = 201, message = "Dia de trader adicionado com sucesso")
	@PostMapping(path = "/createDayTrade")
	public ResponseEntity<DayTradeHttpModel> createUser(@RequestBody DayTradeHttpModel dayTradeHttpModel) {

		DayTradeEntity dayTradeEntity = createDayTradeUseCase.createDayTrade(mapper.to(dayTradeHttpModel));

		if (dayTradeEntity == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(mapper.from(dayTradeEntity));
		}

	}
}
