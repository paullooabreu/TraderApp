package com.tradeapp.dataproviders.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradeapp.core.model.TradeEntity;
import com.tradeapp.dataproviders.models.TradeTable;
import com.tradeapp.service.util.mapper.FromToMapper;

@Component
public class TradeTableMapper extends FromToMapper<TradeTable, TradeEntity> {

	@Autowired
	private DayTradeTableMapper mapper;

	@Override
	protected TradeTable fromNonNull(TradeEntity entity) {
		return TradeTable.builder().cod(entity.getCod()).date_trade(entity.getDate_trade())
				.type_trade(entity.getType_trade()).contract_amount(entity.getContract_amount())
				.contract_price(entity.getContract_price()).price_trade(entity.getPrice_trade())
				.price_final_trade(entity.getPrice_final_trade()).result_type_trade(entity.getResult_type_trade())
				.trade_profit(entity.getTrade_profit()).description(entity.getDescription())
				.day_trade(mapper.from(entity.getDay_trade())).build();
	}

	@Override
	protected TradeEntity toNonNull(TradeTable entity) {
		return TradeEntity.builder().cod(entity.getCod()).date_trade(entity.getDate_trade())
				.type_trade(entity.getType_trade()).contract_amount(entity.getContract_amount())
				.contract_price(entity.getContract_price()).price_trade(entity.getPrice_trade())
				.price_final_trade(entity.getPrice_final_trade()).result_type_trade(entity.getResult_type_trade())
				.trade_profit(entity.getTrade_profit()).description(entity.getDescription())
				.day_trade(mapper.to(entity.getDay_trade())).build();
	}
}
