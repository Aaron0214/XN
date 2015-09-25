package com.xc.xnode.common.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	List<T> list = new ArrayList<T>();

	private Long total = 0L; // 总个数

	private Long pageNumber = 1L; // 第..页

	private Long pageSize = 10L; // 每页..个

	private Long totalPages = 1L; // 总页数

	private String orderProperty; // 排序字段

	private String orderDirection; // 排序方向

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
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

	public Long getTotalPages() {
		if(null == total || null == pageSize){
			return totalPages;
		}
		return Math.round(Math.ceil(total * 1.0 /pageSize));
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
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
