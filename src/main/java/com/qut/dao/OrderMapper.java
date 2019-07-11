package com.qut.dao;

import com.qut.po.Orderbase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;



@Repository("orderMapper")
@Mapper
public interface OrderMapper {
	 int addOrder(Orderbase orderbase);
	 int addOrderDetail(Map<String, Object> map);
	 List<Map<String, Object>> selectGoodsShop(Integer uid);
	 int updateStore(Map<String, Object> map);
	 int clear(Integer uid);
	 int pay(Integer ordersn);
}
