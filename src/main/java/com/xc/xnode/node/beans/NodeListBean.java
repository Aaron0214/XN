package com.xc.xnode.node.beans;

import java.util.ArrayList;
import java.util.List;

import com.xc.xnode.common.beans.CommonBean;

public class NodeListBean extends CommonBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<NodeBean> list = new ArrayList<NodeBean>();

	public List<NodeBean> getList() {
		return list;
	}

	public void setList(List<NodeBean> list) {
		this.list = list;
	}
	
	

}
