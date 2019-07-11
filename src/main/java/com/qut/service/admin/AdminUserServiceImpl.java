package com.qut.service.admin;

import com.qut.dao.BuserMapper;
import com.qut.dao.CartMapper;
import com.qut.dao.FocusMapper;
import com.qut.dao.OrderbaseMapper;
import com.qut.po.CartExample;
import com.qut.po.FocusExample;
import com.qut.po.OrderbaseExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService{
	@Autowired
	OrderbaseMapper orderbaseMapper;

	@Autowired
	CartMapper cartMapper;

	@Autowired
	FocusMapper focusMapper;

	@Autowired
	BuserMapper buserMapper;
	public String userInfo(Model model) {
		model.addAttribute("userList", buserMapper.selectByExample(null));
		return "admin/userManager";
	}

	public String deleteuserManager(Integer id, Model model) {
		//通用mapper默认的方法
		CartExample cartExample = new CartExample();
		FocusExample focusExample = new FocusExample();
		OrderbaseExample orderbaseExample = new OrderbaseExample();
		CartExample.Criteria cartCriteria = cartExample.createCriteria();
		FocusExample.Criteria focusCriteria = focusExample.createCriteria();
		OrderbaseExample.Criteria orderbaseCriteria = orderbaseExample.createCriteria();
		//封装条件
		cartCriteria.andBusertableIdEqualTo(id);
		focusCriteria.andBusertableIdEqualTo(id);
		orderbaseCriteria.andBusertableIdEqualTo(id);

		long countCart = cartMapper.countByExample(cartExample);
		long focusCart = focusMapper.countByExample(focusExample);
		long orderdetailCart = orderbaseMapper.countByExample(orderbaseExample);
		//用户有关联
		if(countCart > 0 || focusCart > 0|| orderdetailCart > 0) {
			model.addAttribute("msg", "用户有关联，不能删除！");
			return "forward:/adminUser/userInfo";
		}
		if(buserMapper.deleteByPrimaryKey(id) > 0)
			model.addAttribute("msg", "成功删除用户！");
		return "forward:/adminUser/userInfo";
	}

}
