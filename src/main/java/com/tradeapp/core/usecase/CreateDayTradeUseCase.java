package com.tradeapp.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeapp.core.model.DayTradeEntity;
import com.tradeapp.core.usecase.gateway.DayTradeGateway;
import com.tradeapp.service.util.mapper.exception.BusinnesException;
import com.tradeapp.util.MessageUtil;

@Component
public class CreateDayTradeUseCase {
	
	@Autowired
	private DayTradeGateway dayTradeGateway;

	public DayTradeEntity createDayTrade(DayTradeEntity dayTradeEntity) {
		DayTradeEntity dayTradeResult;
		
		try {
			dayTradeResult = dayTradeGateway.createDayTrade(dayTradeEntity);
		} catch (Exception e) {
			throw new BusinnesException(MessageUtil.DAY_TRADE_ERROR);
		}
		return dayTradeResult;
	}
}
