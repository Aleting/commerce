package com.qut.dao;


import com.qut.po.Orderbase;
import com.qut.po.OrderbaseExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("orderbaseMapper")
@Mapper
public interface OrderbaseMapper {
    List<Map<String,Object>> orderInfo();

    long countByExample(OrderbaseExample example);

    int deleteByExample(OrderbaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orderbase record);

    int insertSelective(Orderbase record);

    List<Orderbase> selectByExample(OrderbaseExample example);

    Orderbase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orderbase record, @Param("example") OrderbaseExample example);

    int updateByExample(@Param("record") Orderbase record, @Param("example") OrderbaseExample example);

    int updateByPrimaryKeySelective(Orderbase record);

    int updateByPrimaryKey(Orderbase record);
}