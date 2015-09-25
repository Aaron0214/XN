package com.xc.xnode.common.enums;

public enum SnTypeEnum {
	
	user_code(0,"用户编码");
	
	private Integer key;
	
	private String value;

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	private SnTypeEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

}

