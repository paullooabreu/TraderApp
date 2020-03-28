package com.tradeapp.core.enums;

import com.tradeapp.util.MessageUtil;

public enum UserTypeEnum {
	ADMINISTRATOR(1L, "ADMINISTRATOR"), SIMPLE(2L, "SIMPLE");

	private Long code;
	private String description;

	private UserTypeEnum(Long code, String description) {
		this.code = code;
		this.description = description;
	}

	public Long getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public static UserTypeEnum getByCode(Long code) {
		for (UserTypeEnum userTypeTableEnum : UserTypeEnum.values()) {
			if (userTypeTableEnum.getCode().equals(code)) {
				return userTypeTableEnum;
			}
		}
		throw new IllegalArgumentException(String.format(MessageUtil.INVALID_CODE, code));
	}

	public static UserTypeEnum getByDescription(String description) {
		for (UserTypeEnum userTypeTableEnum : UserTypeEnum.values()) {
			if (userTypeTableEnum.getDescription().equals(description)) {
				return userTypeTableEnum;
			}
		}
		throw new IllegalArgumentException(String.format(MessageUtil.INVALID_DESCRIPTION, description));
	}
}
