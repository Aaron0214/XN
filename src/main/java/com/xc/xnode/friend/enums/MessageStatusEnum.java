package com.xc.xnode.friend.enums;

public enum MessageStatusEnum {
	
	SENDING("S","请求中"),COMFIRE("C","同意"),REJECT("R","拒绝"),DELETE("D","已删除");
	
	private String status;
	
	private String value;

	public String getStatus() {
		return status;
	}

	public String getValue() {
		return value;
	}
	
	private MessageStatusEnum(String status,String value){
		this.status = status;
		this.value = value;
	}
}
