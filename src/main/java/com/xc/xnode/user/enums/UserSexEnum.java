package com.xc.xnode.user.enums;

public enum UserSexEnum {
	
	MAN(0,"男"),WOMAN(1,"女");
	
	private Integer key;
	
	private String value;

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	private UserSexEnum(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public static String getValueByKey(Integer sex){
		for(UserSexEnum userSex : UserSexEnum.values()){
			if(userSex.getKey() == sex){
				return userSex.getValue();
			}
		}
		return "";
	}
	
}
