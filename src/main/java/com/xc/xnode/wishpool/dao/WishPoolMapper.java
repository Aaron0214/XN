package com.xc.xnode.wishpool.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xc.xnode.wishpool.domain.SearchParams;
import com.xc.xnode.wishpool.domain.WishPool;
import com.xc.xnode.wishpool.domain.WishPoolUser;

public interface WishPoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WishPool record);

    int insertSelective(WishPool record);

    WishPool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WishPool record);

    int updateByPrimaryKey(WishPool record);
    
    List<WishPoolUser> getWishListByUser(@Param("username")String usernam);
    
    List<WishPoolUser> getWishListByParams(SearchParams searchParams);
}