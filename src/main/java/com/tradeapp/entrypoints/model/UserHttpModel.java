package com.tradeapp.entrypoints.model;

import com.tradeapp.entrypoints.enums.UserTypeHttpModelEnum;

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
public class UserHttpModel {

	private Long cod;

	private String name;

	private String email;

	private String password;

	private UserTypeHttpModelEnum userType;

}
