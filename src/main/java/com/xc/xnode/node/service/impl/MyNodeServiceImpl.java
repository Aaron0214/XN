/**
 * 
 */
package com.xc.xnode.node.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xc.xnode.common.beans.SearchBean;
import com.xc.xnode.common.exception.BaseException;
import com.xc.xnode.node.beans.NodeBean;
import com.xc.xnode.node.beans.NodeListBean;
import com.xc.xnode.node.dao.NodeMapper;
import com.xc.xnode.user.dao.UserMapper;
import com.xc.xnode.node.domain.Node;
import com.xc.xnode.node.domain.UserNode;
import com.xc.xnode.node.service.MyNodeService;
import com.xc.xnode.utils.DateUtils;

/**
 * @author e592387
 *
 */
@Service
public class MyNodeServiceImpl implements MyNodeService{
	
	@Autowired
	private NodeMapper nodeMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public NodeListBean getNodeList(SearchBean searchBean) {
		NodeListBean listBean = new NodeListBean();
		List<NodeBean> list = new ArrayList<NodeBean>();
		List<UserNode> nodeList = nodeMapper.selectNodes(searchBean.getUsername());
		Integer index = 1;
		for(UserNode node : nodeList){
			NodeBean nodeBean = buildNodeBean(node,index);
			list.add(nodeBean);
		}
		listBean.setList(list);
		return listBean;
	}
	
	private NodeBean buildNodeBean(Node node){
		NodeBean nodeBean = new NodeBean();
		try{
			nodeBean.setId(node.getId());
			nodeBean.setTitle(node.getTitle());
			nodeBean.setContent(node.getContent());
			nodeBean.setCreateDate(DateUtils.parseLongDate(node.getCreateDate()));
			nodeBean.setModifyDate(DateUtils.parseLongDate(node.getModifyDate()));
		}catch(Exception e){
			
		}
		return nodeBean;
	}
	
	private NodeBean buildNodeBean(UserNode node,Integer index){
		NodeBean nodeBean = new NodeBean();
		try{
			nodeBean.setId(node.getId());
			nodeBean.setIndex(index++);
			nodeBean.setTitle(node.getTitle());
			nodeBean.setContent(node.getContent());
			nodeBean.setUsername(node.getUsername());
			nodeBean.setCreateDate(DateUtils.parseLongDate(node.getCreateDate()));
			nodeBean.setModifyDate(DateUtils.parseLongDate(node.getModifyDate()));
		}catch(Exception e){
			
		}
		return nodeBean;
	}

	@Override
	@Transactional
	public void saveNode(NodeBean nodeBean,String username) throws BaseException{
		try{
			Node node = new Node();
			node.setTitle(nodeBean.getTitle());
			node.setContent(nodeBean.getContent());
			node.setCreateDate(new Date());
			node.setModifyDate(new Date());
			node.setUserId(userMapper.selectUserByUserName(username).getId());
			nodeMapper.insertSelective(node);
		}catch(Exception e){
			throw new BaseException(e.getMessage());
		}
		
	}

	@Override
	public NodeBean selectNodeById(Integer id) {
		NodeBean nodeBean = buildNodeBean(nodeMapper.selectByPrimaryKey(id));
		return nodeBean;
	}

}
