package com.tradeapp.dataproviders.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tradeapp.dataproviders.models.UserTable;

public interface UserRepository extends JpaRepository<UserTable, Long> {

	public Optional<UserTable> findByEmail(String email);
}
