package com.qut.dao;


import com.qut.po.Buser;
import com.qut.po.BuserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("buserMapper")
@Mapper
public interface BuserMapper {
    long countByExample(BuserExample example);

    int deleteByExample(BuserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Buser record);

    int insertSelective(Buser record);

    List<Buser> selectByExample(BuserExample example);

    Buser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Buser record, @Param("example") BuserExample example);

    int updateByExample(@Param("record") Buser record, @Param("example") BuserExample example);

    int updateByPrimaryKeySelective(Buser record);

    int updateByPrimaryKey(Buser record);
}