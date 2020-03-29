package com.tradeapp.dataproviders.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeapp.core.model.DayTradeEntity;
import com.tradeapp.dataproviders.models.DayTradeTable;
import com.tradeapp.service.util.mapper.FromToMapper;

@Component
public class DayTradeTableMapper extends FromToMapper<DayTradeTable, DayTradeEntity> {

	@Autowired
	private UserTableMapper mapper;

	@Autowired
	private TradeTableMapper tradeMapper;

	@Override
	protected DayTradeTable fromNonNull(DayTradeEntity entity) {
		return DayTradeTable.builder().cod(entity.getCod()).name(entity.getName()).description(entity.getDescription())
				.date_day(entity.getDate_day()).daily_profit(entity.getDaily_profit())
				.user(mapper.from(entity.getUser())).trades(tradeMapper.fromList(entity.getTrades())).build();
	}

	@Override
	protected DayTradeEntity toNonNull(DayTradeTable entity) {
		return DayTradeEntity.builder().cod(entity.getCod()).name(entity.getName()).description(entity.getDescription())
				.date_day(entity.getDate_day()).daily_profit(entity.getDaily_profit()).user(mapper.to(entity.getUser()))
				.trades(tradeMapper.toList(entity.getTrades())).build();
	}

}
