package com.xc.xnode.user.enums;

public enum AddressTpeEnum {
	
	Bir_address(0,"出生地"),now_address(1,"现住址");
	
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
	
	private AddressTpeEnum(Integer key,String value){
		this.key = key;
		this.value = value;
	}

}
