package com.tradeapp.dataproviders.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trade")
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TradeTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod")
	private Long cod;
	
	@Column(name = "date_trade")
	private LocalDateTime date_trade;
	
	@Column(name = "type_trade")
	private String type_trade;
	
	@Column(name = "contract_amount")
	private Long contract_amount;
	
	@Column(name = "contract_price")
	private Double contract_price;
	
	@Column(name = "price_trade")
	private Long price_trade;
	
	@Column(name = "price_final_trade")
	private Long price_final_trade;
	
	@Column(name = "result_type_trade")
	private String result_type_trade;
	
	@Column(name = "trade_profit")
	private Double trade_profit;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_day_trade")
	private DayTradeTable day_trade;

}
