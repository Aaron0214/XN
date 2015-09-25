package com.xc.xnode.wishpool.dao;

import java.util.Map;

import com.xc.xnode.wishpool.domain.WisherDesire;

public interface WisherDesireMapper {
    int insert(WisherDesire record);

    int insertSelective(WisherDesire record);
    
    WisherDesire selectByParams(Map<String,Object> params);
}