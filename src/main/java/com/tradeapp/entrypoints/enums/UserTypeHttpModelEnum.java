package com.tradeapp.entrypoints.enums;

import com.tradeapp.util.MessageUtil;

public enum UserTypeHttpModelEnum {

	ADMINISTRATOR(1L, "ADMINISTRATOR"), SIMPLE(2L, "SIMPLE");

	private Long code;
	private String description;

	private UserTypeHttpModelEnum(Long code, String description) {
		this.code = code;
		this.description = description;
	}

	public Long getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}

	public static UserTypeHttpModelEnum getByCode(Long code) {
		for (UserTypeHttpModelEnum userTypeTableEnum : UserTypeHttpModelEnum.values()) {
			if (userTypeTableEnum.getCode().equals(code)) {
				return userTypeTableEnum;
			}
		}
		throw new IllegalArgumentException(String.format(MessageUtil.INVALID_CODE, code));
	}

	public static UserTypeHttpModelEnum getByDescription(String description) {
		for (UserTypeHttpModelEnum userTypeTableEnum : UserTypeHttpModelEnum.values()) {
			if (userTypeTableEnum.getDescription().equals(description)) {
				return userTypeTableEnum;
			}
		}
		throw new IllegalArgumentException(String.format(MessageUtil.INVALID_DESCRIPTION, description));
	}
}
