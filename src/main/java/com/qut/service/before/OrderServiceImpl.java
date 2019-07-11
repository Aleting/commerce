package com.qut.service.before;

import com.qut.dao.GoodsMapper;
import com.qut.dao.OrderMapper;
import com.qut.dao.OrderbaseMapper;
import com.qut.po.Orderbase;
import com.qut.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
@Transactional
/**
 * 订单生成有连串的更新操作，此处必须使用事务管理
 */
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private OrderbaseMapper orderbaseMapper;
	/**
	 * 订单提交，连续的事务处理
	 */

	public String orderSubmit(Model model, HttpSession session, Double amount) {
		Orderbase order = new Orderbase();
		order.setAmount(amount);
		order.setBusertableId(MyUtil.getUserId(session));
		//生成订单，并将主键返回order
		orderMapper.addOrder(order);
		//生成订单详情
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ordersn", order.getId());
		map.put("uid", MyUtil.getUserId(session));
		orderMapper.addOrderDetail(map);
		//更新商品库存
		//更新商品库存1.查询商品购买量，以便更新库存使用
		List<Map<String, Object>> list = orderMapper.selectGoodsShop(MyUtil.getUserId(session));
		//更新商品库存2.根据商品购买量更新库存
		for (Map<String, Object> map2 : list) {
			orderMapper.updateStore(map2);
		}
		//清空购物车
		orderMapper.clear(MyUtil.getUserId(session));
		model.addAttribute("ordersn", order.getId());
		return "before/orderdone";
	}

	public String pay(Integer ordersn) {
		orderMapper.pay(ordersn);
		return "before/paydone";
	}

	@Override
	public Orderbase getOrderById(int id) {
		return orderbaseMapper.selectByPrimaryKey(id);
	}


}
