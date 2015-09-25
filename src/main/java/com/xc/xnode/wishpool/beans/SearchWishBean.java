package com.xc.xnode.wishpool.beans;

import com.xc.xnode.common.beans.SearchBean;

public class SearchWishBean extends SearchBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private String wishtext;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getWishtext() {
		return wishtext;
	}

	public void setWishtext(String wishtext) {
		this.wishtext = wishtext;
	}
}
