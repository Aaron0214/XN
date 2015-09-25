package com.xc.xnode.node.service;

import com.xc.xnode.common.beans.SearchBean;
import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.node.beans.NodeListBean;
import com.xc.xnode.node.beans.NodeBean;

public interface MyNodeService {
	
	public NodeListBean getNodeList(SearchBean searchBean);
	
	public void saveNode(NodeBean nodeBean,String username) throws BaseException;
	
	public NodeBean selectNodeById(Integer id);
}
