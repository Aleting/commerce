package com.qut.service.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qut.dao.CartMapper;
import com.qut.dao.FocusMapper;
import com.qut.dao.GoodsMapper;
import com.qut.dao.OrderdetailMapper;
import com.qut.po.CartExample;
import com.qut.po.FocusExample;
import com.qut.po.Goods;
import com.qut.po.OrderdetailExample;
import com.qut.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Service("adminGoodsService")
@Transactional
public class AdminGoodsServiceImpl implements AdminGoodsService{
	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private CartMapper cartMapper;

	@Autowired
	private FocusMapper focusMapper;

	@Autowired
	private OrderdetailMapper orderdetailMapper;
	/**
	 * 添加或更新
	 */
	public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct) {
		/*上传文件的保存位置"/logos"，该位置是指
		workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps，
		发布后使用*/
		//防止文件名重名
		String newFileName = "";
		String fileName = goods.getLogoImage().getOriginalFilename();
		//选择了文件
		if(fileName.length() > 0){
			String realpath = request.getServletContext().getRealPath("logos");
			//获取文件类型
			String fileType = fileName.substring(fileName.lastIndexOf('.'));
			//防止文件名重名
			newFileName = MyUtil.getStringID() + fileType;
			goods.setGpicture(newFileName);
			File targetFile = new File(realpath, newFileName);
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			//上传
			try {
				goods.getLogoImage().transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//修改
		if("update".equals(updateAct)){//updateAct不能与act重名，因为使用了转发
			//修改到数据库
			if(goodsMapper.updateByPrimaryKey(goods) > 0){
				return "forward:/adminGoods/selectGood?act=updateSelect";
			}else{
				return "admin/updateAgoods";
			}
		}else{//添加数据库方法
			if(goodsMapper.insertSelective(goods) > 0){
				//转发到查询的controller
				return "forward:/adminGoods/selectGood";
			}else{
				return "admin/addGoods";
			}
		}
	}

	/**
	 * 查询一个商品
	 */

	public String selectAGoods(Model model, Integer id, String act) {

		Goods agoods = goodsMapper.selectByPrimaryKey(id);
		model.addAttribute("goods", agoods);
		//修改页面
		if("updateAgoods".equals(act)){
			return "admin/updateAgoods";
		}
		//详情页面
		return "admin/goodsDetail";
	}
	/**
	 * 删除一个、多个商品
	 */
	public String deleteGoods(Integer[] ids, Model model) {
		System.out.println("id"+ids[0]);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < ids.length; i++) {
		    //创建对象
			CartExample cartExample = new CartExample();
			FocusExample focusExample = new FocusExample();
			OrderdetailExample orderdetailExample = new OrderdetailExample();
            //准备对条件进行封装
			CartExample.Criteria cartCriteria = cartExample.createCriteria();
			FocusExample.Criteria focusCriteria = focusExample.createCriteria();
			OrderdetailExample.Criteria orderdetailCriteria = orderdetailExample.createCriteria();

			cartCriteria.andGoodstableIdEqualTo(ids[i]);
			focusCriteria.andGoodstableIdEqualTo(ids[i]);
			orderdetailCriteria.andGoodstableIdEqualTo(ids[i]);

			long countCart = cartMapper.countByExample(cartExample);
			long focusCart = focusMapper.countByExample(focusExample);
			long orderdetailCart = orderdetailMapper.countByExample(orderdetailExample);
			if(countCart > 0 || focusCart > 0 || orderdetailCart > 0) {
				model.addAttribute("msg", "商品有关联，不允许删除！");
				return "forward:/adminGoods/selectGood?act=deleteSelect";
			}
			list.add(ids[i]);
		}
		for(Integer i:list){
			goodsMapper.deleteByPrimaryKey(i);
		}
		model.addAttribute("msg", "成功删除商品！");
		return "forward:/adminGoods/selectGood?act=deleteSelect";
	}
	/**
	 * 删除一个商品
	 */
	public String deleteAGoods(Integer id, Model model) {
		Integer [] ids=new Integer[1];
		ids[0]=id;
		return deleteGoods(ids,model);
	}

	public String selectGood( Model model,Integer pageCur,String act){
		//引入PageHelper插件,传入页码，以及每页大小
		PageHelper.startPage(pageCur,10);
		List<Goods> goods = goodsMapper.selectByExample(null);
		//对结果进行封装,参数为封装的数组以及显示的页数
		PageInfo page = new PageInfo(goods);
		model.addAttribute("pageInfo",page);
		//删除查询
		if("deleteSelect".equals(act)){
			return "admin/deleteSelectGoods";
		}
		//修改查询
		else if("updateSelect".equals(act)){
			return "admin/updateSelectGoods";
		}else{
			return "admin/selectGoods";
		}
	}
}
