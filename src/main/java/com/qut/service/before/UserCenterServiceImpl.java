package com.qut.service.before;

import com.qut.dao.UserCenterMapper;
import com.qut.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;



@Service("userCenterService")
@Transactional
public class UserCenterServiceImpl implements UserCenterService{
	@Autowired
	private UserCenterMapper userCenterMapper;

	public String userCenter(HttpSession session, Model model) {
		model.addAttribute("myOrder", userCenterMapper.myOrder(MyUtil.getUserId(session)));
		model.addAttribute("myFocus", userCenterMapper.myFocus(MyUtil.getUserId(session)));
		return "before/userCenter";
	}

	public String orderDetail(Model model, Integer ordersn) {
		model.addAttribute("myOrderDetail", userCenterMapper.orderDetail(ordersn));
		return "before/userOrderDetail";
	}

}
