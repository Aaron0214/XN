package com.xc.xnode.node.domain;

import java.util.Date;
import com.xc.xnode.user.domain.User;

public class UserNode {
	
	private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private Date createDate;

    private Date modifyDate;

    private String comments;
    
    //user
    private User user;
    
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getName() {
		return user.getName();
	}

	public String getUsername() {
		return user.getUsername();
	}
    
}
