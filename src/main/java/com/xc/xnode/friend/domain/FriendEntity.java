package com.xc.xnode.friend.domain;

import java.io.Serializable;

public class FriendEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private String name;
	
	private String username;
	
	private Integer sex;
	
	private Integer wishNum;
	
	private Integer nodeNum;
	
	private Integer frinedNum;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public Integer getSex() {
		return sex;
	}

	public Integer getWishNum() {
		return wishNum;
	}

	public Integer getNodeNum() {
		return nodeNum;
	}

	public Integer getFrinedNum() {
		return frinedNum;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public void setWishNum(Integer wishNum) {
		this.wishNum = wishNum;
	}

	public void setNodeNum(Integer nodeNum) {
		this.nodeNum = nodeNum;
	}

	public void setFrinedNum(Integer frinedNum) {
		this.frinedNum = frinedNum;
	}
}
