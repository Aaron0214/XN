package com.xc.xnode.friend.enums;

public enum MessageTypeEnum {
	
	ADD_FRIEND("A","添加好友");
	
	private String key;
	
	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	private MessageTypeEnum(String key,String value){
		this.key = key;
		this.value = value;
	}
}
