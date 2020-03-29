package com.tradeapp.core.usecase.gateway;

import com.tradeapp.core.model.DayTradeEntity;

public interface DayTradeGateway {

	DayTradeEntity createDayTrade(DayTradeEntity dayTradeEntity);

}
