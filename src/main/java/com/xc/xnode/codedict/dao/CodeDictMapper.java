package com.xc.xnode.codedict.dao;

import java.util.List;

import com.xc.xnode.codedict.domain.CodeDict;

public interface CodeDictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CodeDict record);

    int insertSelective(CodeDict record);

    CodeDict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CodeDict record);

    int updateByPrimaryKey(CodeDict record);
    
    List<CodeDict> selectDistictList(String code);
    
    List<CodeDict> selectDistictListByPid(Integer pid);
    
    Integer getIdByCode(String code);
}