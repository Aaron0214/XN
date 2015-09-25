package com.xc.xnode.friend.dao;

import java.util.List;
import java.util.Map;

import com.xc.xnode.friend.domain.Friend;
import com.xc.xnode.friend.domain.FriendEntity;

public interface FriendMapper {
    int insert(Friend record);

    int insertSelective(Friend record);
    
    List<FriendEntity> selectFriendList(Map<String,Object> params);
    
    List<String> selectUnFriendList(Map<String,String> params);
    
    int deleteFriengByParams(Map<String,Integer> params);
}
