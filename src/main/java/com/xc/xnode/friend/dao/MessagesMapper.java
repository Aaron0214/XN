package com.xc.xnode.friend.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xc.xnode.friend.domain.FriendMessage;
import com.xc.xnode.friend.domain.Messages;

public interface MessagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Messages record);

    int insertSelective(Messages record);

    Messages selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Messages record);

    int updateByPrimaryKey(Messages record);
    
    List<FriendMessage> selectMessagesByReceiver(@Param("loginUser") String loginUser,@Param("username") String username);
    
    List<Messages> selectMessagesByParams(Map<String,Object> params);
}