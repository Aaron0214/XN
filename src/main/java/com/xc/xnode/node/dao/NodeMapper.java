package com.xc.xnode.node.dao;

import java.util.List;

import com.xc.xnode.node.domain.Node;
import com.xc.xnode.node.domain.UserNode;

public interface NodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Node record);

    int insertSelective(Node record);

    Node selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Node record);

    int updateByPrimaryKey(Node record);
    
    List<UserNode> selectNodes(String username);
}