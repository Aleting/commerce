package com.qut.service.before;

import com.qut.dao.CartMapper;
import com.qut.dao.FocusMapper;
import com.qut.po.Cart;
import com.qut.po.CartExample;
import com.qut.po.Focus;
import com.qut.po.FocusExample;
import com.qut.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Date;



@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService{
	@Autowired
	private CartMapper cartMapper;

	@Autowired
	private FocusMapper focusMapper;

	public String focus(Model model, Integer id, HttpSession session) {
		Focus focus = new Focus();
		focus.setBusertableId(MyUtil.getUserId(session));
		focus.setGoodstableId(id);
		focus.setFocustime(new Date());
		FocusExample example = new FocusExample();
		FocusExample.Criteria criteria = example.createCriteria();
		criteria.andBusertableIdEqualTo(MyUtil.getUserId(session));
		criteria.andGoodstableIdEqualTo(id);
		long count = focusMapper.countByExample(example);
		if(count > 0) {
			model.addAttribute("msg", "已关注该商品！");
		}else {
			focusMapper.insertSelective(focus);
			model.addAttribute("msg", "成功关注该商品！");
		}
		return "forward:/goodsDetail?id=" + id;
	}

	public String putCart(Model model, Integer shoppingnum, Integer id, HttpSession session) {
		CartExample example = new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andBusertableIdEqualTo(MyUtil.getUserId(session));
		criteria.andGoodstableIdEqualTo(id);
		//criteria.andShoppingnumEqualTo(shoppingnum);
		//是否已添加购物车
		List<Cart> carts = cartMapper.selectByExample(example);
		Cart cart = new Cart();
		if(carts.size() > 0){
			cart = new Cart(null,MyUtil.getUserId(session),id,shoppingnum+carts.get(0).getShoppingnum());
			cartMapper.updateByExampleSelective(cart,example);
		}
		else{
			cart.toString();
			cart = new Cart(null,MyUtil.getUserId(session),id,shoppingnum);
			cartMapper.insertSelective(cart);
		}
		return "forward:/cart/selectCart";
	}

	public String selectCart(Model model, HttpSession session) {
		List<Map<String, Object>> list = cartMapper.selectCart(MyUtil.getUserId(session));
		double sum = 0;
		for (Map<String, Object> map : list) {
			sum = sum + (Double)map.get("smallsum");
		}
		model.addAttribute("total", sum);
		model.addAttribute("cartlist", list);
			return "before/cart";
	}

	public String deleteAgoods(Integer id, HttpSession session) {
		CartExample example = new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andBusertableIdEqualTo(MyUtil.getUserId(session));
		criteria.andGoodstableIdEqualTo(id);
		cartMapper.deleteByExample(example);
		return "forward:/cart/selectCart";
	}

	public String clear(HttpSession session) {
		CartExample example = new CartExample();
		CartExample.Criteria criteria = example.createCriteria();
		criteria.andBusertableIdEqualTo(MyUtil.getUserId(session));
		cartMapper.deleteByExample(example);
		return "forward:/cart/selectCart";
	}
	public String orderConfirm(Model model, HttpSession session){
		List<Map<String, Object>> list = cartMapper.selectCart(MyUtil.getUserId(session));
		double sum = 0;
		for (Map<String, Object> map : list) {
			sum = sum + (Double)map.get("smallsum");
		}
		model.addAttribute("total", sum);
		model.addAttribute("cartlist", list);
			return "before/orderconfirm";

	}

}
