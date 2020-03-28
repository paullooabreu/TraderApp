package com.tradeapp.core.model;

import com.tradeapp.core.enums.UserTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	private Long cod;

	private String name;

	private String email;

	private String password;

	private UserTypeEnum userType;
}
