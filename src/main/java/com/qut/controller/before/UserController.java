package com.qut.controller.before;

import com.qut.po.Buser;
import com.qut.service.before.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/register")
	//ModelAttribute用于前端传递过来的数据进行数据绑定
	public String register(@ModelAttribute Buser buser, Model model, HttpSession session, String code) {
		return userService.register(buser, model, session, code.toLowerCase());
	}
	@RequestMapping("/login")
	public String login(@ModelAttribute Buser buser,Model model, HttpSession session, String code) {
		return userService.login(buser, model, session, code.toLowerCase());
	}
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "forward:/before";
	}
	@RequestMapping("/emailActivation")
	public String emailActivation(@RequestParam("bemail") String bemail, @RequestParam("state") String state){
		Buser buser = new Buser();
		buser.setBemail(bemail);
		buser.setState(state);
		boolean flog = userService.emailActivation(buser);
		if(flog){
			System.out.print("ok");
			return "forward:/before";
		}else {
			return "error/error";
		}

	}
}

