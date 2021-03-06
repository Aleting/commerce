package com.qut.controller.admin;


import com.qut.po.Notice;
import com.qut.service.admin.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController {
	@Autowired
	private AdminNoticeService adminNoticeService;
	@RequestMapping("/toAddNotice")
	public String toAddNotice(Model model) {
		model.addAttribute("notice", new Notice());
		return "admin/addNotice";
	}
	@RequestMapping("/addNotice")
	public String addNotice(@ModelAttribute Notice notice) {
		return adminNoticeService.addNotice(notice);
	}
	@RequestMapping("/deleteNoticeSelect")
	public String deleteNoticeSelect(Model model) {
		return adminNoticeService.deleteNoticeSelect(model);
	}
	@RequestMapping("/selectANotice")
	public String selectANotice(Model model, Integer id) {
		return adminNoticeService.selectANotice(model, id);
	}
	@RequestMapping("/deleteNotice")
	public String deleteNotice(@RequestParam("id") Integer id) {
		return adminNoticeService.deleteNotice(id);
	}
}
