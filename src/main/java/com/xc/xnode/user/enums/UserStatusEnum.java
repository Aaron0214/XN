package com.xc.xnode.user.enums;

public enum UserStatusEnum {

	NORMAL(0,"正常"),LOCK(1,"锁定"),UN_NORMAL(2,"异常");
	
	private Integer key;
	
	private String value;
	
	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	private UserStatusEnum(Integer key,String value){
		this.key = key;
		this.value = value;
	}
	
	public static String getValueByKey(Integer status){
		for(UserStatusEnum userStatus : UserStatusEnum.values()){
			if(userStatus.getKey() == status){
				return userStatus.getValue();
			}
		}
		return "";
	}

}
