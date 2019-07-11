package com.qut.dao;

import com.qut.po.Auser;
import com.qut.po.AuserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("auserMapper")
@Mapper
public interface AuserMapper {
    long countByExample(AuserExample example);

    int deleteByExample(AuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Auser record);

    int insertSelective(Auser record);

    List<Auser> selectByExample(AuserExample example);

    Auser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Auser record, @Param("example") AuserExample example);

    int updateByExample(@Param("record") Auser record, @Param("example") AuserExample example);

    int updateByPrimaryKeySelective(Auser record);

    int updateByPrimaryKey(Auser record);
}