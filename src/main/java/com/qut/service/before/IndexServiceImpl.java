package com.qut.service.before;

import com.qut.dao.GoodstypeMapper;
import com.qut.dao.IndexMapper;
import com.qut.dao.NoticeMapper;
import com.qut.po.Buser;
import com.qut.po.Goods;
import com.qut.po.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;



@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService {
	@Autowired
	private IndexMapper indexMapper;
	@Autowired
	private GoodstypeMapper goodstypeMapper;
	@Autowired
	private NoticeMapper noticeMapper;

	public String before(Model model, HttpSession session, Goods goods) {
		session.setAttribute("goodsType", goodstypeMapper.selectByExample(null));//导航栏的商品类型
		model.addAttribute("salelist", indexMapper.getSaleOrder());//销售排行
		model.addAttribute("focuslist", indexMapper.getFocusOrder());//人气排行
		model.addAttribute("noticelist", indexMapper.selectNotice());//公告栏
		if(goods.getId() == null)
			goods.setId(0);
		model.addAttribute("lastedlist", indexMapper.getLastedGoods(goods));//最新商品
		return "before/index";
	}


	public String toRegister(Model model) {
		model.addAttribute("rbuser", new Buser());
		return "before/register";
	}


	public String toLogin(Model model) {
		model.addAttribute("lbuser", new Buser());
		return "before/login";
	}


	public String goodsDetail(Model model, Integer id) {
		Goods goods = indexMapper.selectGoodsById(id);
		model.addAttribute("goods", goods);
		return "before/goodsdetail";
	}


	public String selectANotice(Model model, Integer id) {
		Notice notice = noticeMapper.selectByPrimaryKey(id);
		model.addAttribute("notice", notice);
		return "admin/noticeDetail";
	}


	public String search(Model model, String mykey) {
		List<Goods> list = indexMapper.search(mykey);
		model.addAttribute("searchlist", list);
		return "before/searchResult";
	}


}
