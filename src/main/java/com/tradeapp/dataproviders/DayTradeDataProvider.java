package com.tradeapp.dataproviders;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeapp.core.model.DayTradeEntity;
import com.tradeapp.core.usecase.gateway.DayTradeGateway;
import com.tradeapp.dataproviders.mapper.DayTradeTableMapper;
import com.tradeapp.dataproviders.models.DayTradeTable;
import com.tradeapp.dataproviders.repository.DayTradeRepository;
import com.tradeapp.service.util.mapper.exception.ServiceUnavailableException;
import com.tradeapp.util.MessageUtil;

@Component
public class DayTradeDataProvider implements DayTradeGateway {

	@Autowired
	private DayTradeTableMapper mapper;

	@Autowired
	private DayTradeRepository dayTradeRepository;

	@Override
	public DayTradeEntity createDayTrade(DayTradeEntity dayTradeEntity) {
		DayTradeTable dayTradeTableResult;

		try {
			dayTradeTableResult = dayTradeRepository.save(mapper.from(dayTradeEntity));
		} catch (Exception e) {
			throw new ServiceUnavailableException(MessageUtil.DAY_TRADE_ERROR);
		}

		return Optional.of(dayTradeTableResult).map(dayTradeResult -> mapper.to(dayTradeResult)).orElse(null);
	}

}
