package com.qut.service.admin;

import com.qut.dao.OrderbaseMapper;
import com.qut.dao.OrderdetailMapper;
import com.qut.po.OrderdetailExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;



@Service("adminOrderService")
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService{
	@Autowired
	private OrderbaseMapper orderbaseMapper;
	@Autowired
	private OrderdetailMapper orderdetailMapper;

	public String orderInfo(Model model) {
		List<Map<String,Object>> list = orderbaseMapper.orderInfo();
		model.addAttribute("orderList", list);
		return "admin/orderManager";
	}

	public String deleteorderManager(Integer id) {
		//先删除明细
		OrderdetailExample example = new OrderdetailExample();
		OrderdetailExample.Criteria criteria = example.createCriteria();
		criteria.andOrderbasetableIdEqualTo(id);
		orderdetailMapper.deleteByExample(example);
		//再删除订单基础
		orderbaseMapper.deleteByPrimaryKey(id);
		return "forward:/adminOrder/orderInfo";
	}

}
