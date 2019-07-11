package com.qut.service.before;

import com.qut.dao.BuserMapper;
import com.qut.po.Buser;
import com.qut.po.BuserExample;
import com.qut.util.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private BuserMapper buserMapper;

	public String register(Buser buser, Model model, HttpSession session, String code) {
		int n = 0;
		BuserExample example = new BuserExample();
		BuserExample.Criteria criteria = example.createCriteria();
		criteria.andBemailEqualTo(buser.getBemail());
		long count1 = buserMapper.countByExample(example);

		if(count1>0){
			model.addAttribute("codeError", "此邮箱已注册！");
			return "before/register";
		}
		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("codeError", "验证码错误！");
			return "before/register";
		}
		//邮箱
		String recode = SendMail.getCode(20);
		try {
			SendMail.sendMail(buser.getBemail(),buser.getBemail(),recode);
			buser.setState(recode);
			buser.setRoleId(2);
			n = buserMapper.insertSelective(buser);
		}catch (Exception e){
			e.printStackTrace();
		}
		if(n > 0) {
			return "before/login";
		}else {
			model.addAttribute("msg", "注册失败！");
			return "before/register";
		}
	}

	public String login(Buser buser, Model model, HttpSession session, String code) {
		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg", "验证码错误！");
			return "before/login";
		}
		Buser ruser = null;
		buser.setState("1");
		BuserExample example = new BuserExample();
		BuserExample.Criteria criteria = example.createCriteria();
		criteria.andBemailEqualTo(buser.getBemail());
		long count1 = buserMapper.countByExample(example);

		if(count1 == 0){
			model.addAttribute("msg", "邮箱未注册！");
			return "before/login";
		}
		criteria.andStateEqualTo("1");
		long count2 = buserMapper.countByExample(example);
		if(count2 == 0){
			model.addAttribute("msg", "邮箱未激活！");
			return "before/login";
		}
		criteria.andBpwdEqualTo(buser.getBpwd());
		long count3 = buserMapper.countByExample(example);
		if(count3 > 0) {
			ruser = buserMapper.selectByExample(example).get(0);
		}
		if(ruser != null) {
			session.setAttribute("bruser", ruser);
			return "forward:/before";
		}else {
			model.addAttribute("msg", "用户名或密码错误！");
			return "before/login";
		}
	}

	public boolean emailActivation(Buser buser){
		BuserExample example = new BuserExample();
		BuserExample.Criteria criteria = example.createCriteria();
		criteria.andBemailEqualTo(buser.getBemail());
		criteria.andStateEqualTo(buser.getState());
		long count1 = buserMapper.countByExample(example);
		if(count1>0){
			buser.setState("1");
			buserMapper.updateByExampleSelective(buser,example);
			return true;
		}
		return false;
	}
 }


