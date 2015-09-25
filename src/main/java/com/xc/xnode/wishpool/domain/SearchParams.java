package com.xc.xnode.wishpool.domain;

import java.util.Date;

public class SearchParams {
	
	private Integer id;
	
	private Date startDate;
	
	private Date endDate;
	
	private String username;
	
	private String wishtext;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWishtext() {
		return wishtext;
	}

	public void setWishtext(String wishtext) {
		this.wishtext = wishtext;
	}
}
