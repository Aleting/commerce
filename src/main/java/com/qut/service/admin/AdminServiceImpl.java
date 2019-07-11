package com.qut.service.admin;

import com.qut.dao.AuserMapper;
import com.qut.dao.GoodstypeMapper;
import com.qut.po.Auser;
import com.qut.po.AuserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AuserMapper auserMapper;
	@Autowired
	private GoodstypeMapper goodstypeMapper;

	public String login(Auser auser, Model model, HttpSession session) {
		AuserExample example = new AuserExample();
		AuserExample.Criteria criteria = example.createCriteria();
		criteria.andAnameEqualTo(auser.getAname());
		criteria.andApwdEqualTo(auser.getApwd());
		long count = auserMapper.countByExample(example);
		if(count > 0) {
			session.setAttribute("auser", auser);
			//添加商品与修改商品页面使用,将商品类型缓存到Session
			session.setAttribute("goodsType", goodstypeMapper.selectByExample(null));
			return "admin/main";
		}
		model.addAttribute("msg", "用户名或密码错误！");
		return "admin/login";
	}


	}
