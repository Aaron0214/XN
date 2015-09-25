package com.xc.xnode.friend.beans;

import com.xc.xnode.common.beans.CommonBean;

public class FriendBean extends CommonBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer index;
	
	private String code;
	
	private String username;
	
	private String name;
	
	private Integer sex;
	
	private String sexValue;
	
	private Integer friendNum;
	
	private Integer nodeNum;
	
	private Integer wishNum;

	public Integer getIndex() {
		return index;
	}

	public String getCode() {
		return code;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public Integer getSex() {
		return sex;
	}

	public String getSexValue() {
		return sexValue;
	}

	public Integer getFriendNum() {
		return friendNum;
	}

	public Integer getNodeNum() {
		return nodeNum;
	}

	public Integer getWishNum() {
		return wishNum;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}

	public void setFriendNum(Integer friendNum) {
		this.friendNum = friendNum;
	}

	public void setNodeNum(Integer nodeNum) {
		this.nodeNum = nodeNum;
	}

	public void setWishNum(Integer wishNum) {
		this.wishNum = wishNum;
	}
}
