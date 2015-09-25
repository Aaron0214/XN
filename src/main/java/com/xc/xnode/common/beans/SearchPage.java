package com.xc.xnode.common.beans;

import java.io.Serializable;

public class SearchPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long offset; // 第..个

	private Long rows; // 取..个

	private Long pageNumber = 1L; // 第..页

	private Long pageSize = 10L; // 每页..个

	private String orderProperty; // 排序字段

	private String orderDirection; // 排序方向

	public Long getOffset() {
		if(null == pageNumber || null == pageSize){
			return offset;
		}
		return (pageNumber-1) * pageSize;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public Long getRows() {
		if(null == pageSize){
			return rows;
		}
		return pageSize;
	}

	public void setRows(Long rows) {
		this.rows = rows;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderProperty() {
		return orderProperty;
	}

	public void setOrderProperty(String orderProperty) {
		this.orderProperty = orderProperty;
	}

	public String getOrderDirection() {
		return orderDirection;
	}

	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
}
