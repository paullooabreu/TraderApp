package com.tradeapp.dataproviders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeapp.dataproviders.models.DayTradeTable;

public interface DayTradeRepository extends JpaRepository<DayTradeTable, Long> {

}
