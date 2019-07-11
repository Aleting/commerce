package com.qut.service.admin;

import com.qut.dao.NoticeMapper;
import com.qut.po.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;


@Service("adminNoticeService")
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService{
	@Autowired
	private NoticeMapper noticeMapper;

	public String addNotice(Notice notice) {
		noticeMapper.insertSelective(notice);
		return "forward:/adminNotice/deleteNoticeSelect";
	}

	public String deleteNoticeSelect(Model model) {
		model.addAttribute("allNotices", noticeMapper.selectByExample(null));
		return "admin/deleteNoticeSelect";
	}

	public String selectANotice(Model model, Integer id) {
		model.addAttribute("notice", noticeMapper.selectByPrimaryKey(id));
		return "admin/noticeDetail";
	}

	public String deleteNotice(Integer id) {
		noticeMapper.deleteByPrimaryKey(id);
		return "forward:/adminNotice/deleteNoticeSelect";
	}
}
