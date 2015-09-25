package com.xc.xnode.common.dao;

import com.xc.xnode.common.domain.Sn;

public interface SnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sn record);

    int insertSelective(Sn record);

    Sn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sn record);

    int updateByPrimaryKey(Sn record);
    
    Sn selectSnByType(Integer type);
}