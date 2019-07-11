package com.qut.service.admin;

import com.qut.dao.GoodsMapper;
import com.qut.dao.GoodstypeMapper;
import com.qut.po.GoodsExample;
import com.qut.po.Goodstype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;


@Service("adminTypeService")
@Transactional
public class AdminTypeServiceImpl implements AdminTypeService{
	@Autowired
	private GoodstypeMapper goodstypeMapper;
	@Autowired
	private GoodsMapper goodsMapper;

	public String toAddType(Model model) {
		model.addAttribute("allTypes", goodstypeMapper.selectByExample(null));
		return "admin/addType";
	}

	public String addType(String typename, Model model, HttpSession session) {
		Goodstype goodstype = new Goodstype();
		goodstype.setTypename(typename);
		goodstypeMapper.insertSelective(goodstype);
		//添加商品与修改商品页面使用
		session.setAttribute("goodsType", goodstypeMapper.selectByExample(null));
		return "forward:/adminType/toAddType";
	}

	public String toDeleteType(Model model) {
		model.addAttribute("allTypes", goodstypeMapper.selectByExample(null));
		return "admin/deleteType";
	}

	public String deleteType(Integer id, Model model) {
		//类型有关联
		GoodsExample example = new GoodsExample();
		GoodsExample.Criteria criteria = example.createCriteria();
		criteria.andGoodstypeIdEqualTo(id);
		long count = goodsMapper.countByExample(example);

		if(count > 0) {
			model.addAttribute("msg", "类型有关联，不允许删除！");
			return "forward:/adminType/toDeleteType";
		}
		if(goodstypeMapper.deleteByPrimaryKey(id) > 0)
			model.addAttribute("msg", "类型成功删除！");
		//回到删除页面
		return "forward:/adminType/toDeleteType";
	}

}
