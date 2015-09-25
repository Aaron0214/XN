package com.xc.xnode.friend.beans;

import com.xc.xnode.common.beans.CommonBean;

public class MessageBean extends CommonBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String senderName;

    private String message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
