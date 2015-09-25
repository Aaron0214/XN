package com.xc.xnode.codedict.enums;

public enum DistrictLevelEnum {
	Country(0,"国家"),provience(1,"省"),city(2,"市/区"),town(3,"县/区"),other(4,"其他");
	
	private Integer level;
	
	private String value;
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	private DistrictLevelEnum(Integer level,String value){
		this.level = level;
		this.value = value;
	}
}
