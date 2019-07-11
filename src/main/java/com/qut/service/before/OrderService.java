package com.qut.service.before;
import com.qut.po.Orderbase;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
public interface OrderService {
	public String orderSubmit(Model model, HttpSession session, Double amount);
	public String pay(Integer ordersn);
	public Orderbase getOrderById(int id);

}
