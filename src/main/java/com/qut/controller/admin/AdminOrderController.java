package com.qut.controller.admin;


import com.qut.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController extends BaseController {
	@Autowired
	private AdminOrderService adminOrderService;
	@RequestMapping("/orderInfo")
	public String orderInfo(Model model) {
		return adminOrderService.orderInfo(model);
	}
	@RequestMapping("/deleteorderManager")
	public String deleteorderManager(@RequestParam("id") Integer id) {
		return adminOrderService.deleteorderManager(id);
	}
}
