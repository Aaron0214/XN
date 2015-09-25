package com.xc.xnode.codedict.enums;

public enum CodeDictTypeEnum {
	
	DISTRICT(1,"地区"),OTHER(2,"其他");
	
	private Integer key;
	
	private String value;
	
	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private CodeDictTypeEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

}
