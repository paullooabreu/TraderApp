package com.tradeapp.entrypoints.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeapp.core.model.DayTradeEntity;
import com.tradeapp.entrypoints.model.DayTradeHttpModel;
import com.tradeapp.service.util.mapper.FromToMapper;

@Component
public class DayTradeHttpModelMapper extends FromToMapper<DayTradeHttpModel, DayTradeEntity> {

	@Autowired
	private UserHttpModelMapper mapper;

	@Autowired
	private TradeHttpModelMapper tradeMapper;

	@Override
	protected DayTradeHttpModel fromNonNull(DayTradeEntity entity) {
		return DayTradeHttpModel.builder().cod(entity.getCod()).name(entity.getName())
				.description(entity.getDescription()).date_day(entity.getDate_day())
				.daily_profit(entity.getDaily_profit()).user(mapper.from(entity.getUser()))
				.trades(tradeMapper.fromList(entity.getTrades())).build();
	}

	@Override
	protected DayTradeEntity toNonNull(DayTradeHttpModel entity) {
		return DayTradeEntity.builder().cod(entity.getCod()).name(entity.getName()).description(entity.getDescription())
				.date_day(entity.getDate_day()).daily_profit(entity.getDaily_profit()).user(mapper.to(entity.getUser()))
				.trades(tradeMapper.toList(entity.getTrades())).build();
	}

}
