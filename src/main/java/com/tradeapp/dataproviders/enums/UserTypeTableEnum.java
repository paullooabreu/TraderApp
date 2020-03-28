package com.tradeapp.dataproviders.enums;

import com.tradeapp.util.MessageUtil;

public enum UserTypeTableEnum {

	ADMINISTRATOR(1L, "ADMINISTRATOR"), SIMPLE(2L, "SIMPLE");

	private Long code;
	private String description;

	private UserTypeTableEnum(Long code, String description) {
		this.code = code;
		this.description = description;
	}

	public Long getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public static UserTypeTableEnum getByCode(Long code) {
		for (UserTypeTableEnum userTypeTableEnum : UserTypeTableEnum.values()) {
			if (userTypeTableEnum.getCode().equals(code)) {
				return userTypeTableEnum;
			}
		}
		throw new IllegalArgumentException(String.format(MessageUtil.INVALID_CODE, code));
	}

	public static UserTypeTableEnum getByDescription(String description) {
		for (UserTypeTableEnum userTypeTableEnum : UserTypeTableEnum.values()) {
			if (userTypeTableEnum.getDescription().equals(description)) {
				return userTypeTableEnum;
			}
		}
		throw new IllegalArgumentException(String.format(MessageUtil.INVALID_DESCRIPTION, description));
	}
}
