package com.xc.xnode.wishpool.beans;

import java.io.Serializable;


public class WishBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
    private String css;

    private String wishText;

    private String username;

    private String template;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getWishText() {
		return wishText;
	}

	public void setWishText(String wishText) {
		this.wishText = wishText;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	} 

}
