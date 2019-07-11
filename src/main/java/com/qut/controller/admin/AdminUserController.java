package com.qut.controller.admin;

import com.qut.service.admin.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController {
	@Autowired
	private AdminUserService adminUserService;
	@RequestMapping("/userInfo")
	public String userInfo(Model model) {
		return adminUserService.userInfo(model);
	}
	@RequestMapping("/deleteuserManager")
	public String deleteuserManager(@RequestParam("id") Integer id, Model model) {
		return adminUserService.deleteuserManager(id, model);
	}
}
