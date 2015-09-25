package com.xc.xnode.wishpool.domain;

import java.io.Serializable;
import java.util.Date;

public class WishPoolUser implements Serializable {
	
	private Integer id;

    private String css;

    private String wishText;

    private Integer userId;

    private Integer template;

    private Date createDate;

    private Date modifyDate;

    private String comments;

    private String username;
    
    private Long wishNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css == null ? null : css.trim();
    }

    public String getWishText() {
        return wishText;
    }

    public void setWishText(String wishText) {
        this.wishText = wishText == null ? null : wishText.trim();
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getTemplate() {
        return template;
    }

    public void setTemplate(Integer template) {
        this.template = template;
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

	public Long getWishNum() {
		return wishNum;
	}

	public void setWishNum(Long wishNum) {
		this.wishNum = wishNum;
	}
}