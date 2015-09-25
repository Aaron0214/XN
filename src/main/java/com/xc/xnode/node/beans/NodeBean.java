package com.xc.xnode.node.beans;

import com.xc.xnode.common.beans.CommonBean;

public class NodeBean extends CommonBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer index;
	
	private Integer id;
	
	private String title;
	
	private String content;
	
	private String createDate;
	
	private String modifyDate;
	
	private String username;

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
