package com.xc.xnode.friend.beans;

import com.xc.xnode.common.beans.CommonBean;

public class FriendAddBean extends CommonBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer level;
	
	private String username;
	
	private String isSendMessage;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIsSendMessage() {
		return isSendMessage;
	}

	public void setIsSendMessage(String isSendMessage) {
		this.isSendMessage = isSendMessage;
	}
}
