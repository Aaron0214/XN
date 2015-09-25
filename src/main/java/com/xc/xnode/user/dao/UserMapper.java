package com.xc.xnode.user.dao;

import java.util.List;
import java.util.Map;

import com.xc.xnode.user.domain.User;
import com.xc.xnode.user.domain.UserEnty;
import com.xc.xnode.user.domain.UserInfo;
import com.xc.xnode.user.domain.UserShow;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectUserByUserName(String username);

    UserInfo selectUserInfoByUserName(String username);

    UserEnty getUserAddress(String username);
    
    List<UserShow> selectUserListByparams(Map<String,Object> params);
}