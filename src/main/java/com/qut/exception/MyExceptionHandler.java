package com.qut.exception;

import com.qut.po.Auser;
import com.qut.po.Buser;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
//如果执行过程中遇到异常将交给HandlerExceptionResolver来解析
public class MyExceptionHandler implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
	   	Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", arg3); 
		//判断其左边对象是否为其右边类的实例，返回boolean类型的数据
       if(arg3 instanceof AdminLoginNoException){
        	arg0.setAttribute("auser", new Auser());
        	arg0.setAttribute("msg", "没有登录，请登录");
        	return new ModelAndView("/admin/login", model);
        } else if(arg3 instanceof UserLoginNoException){
        	arg0.setAttribute("buser", new Buser());
        	arg0.setAttribute("msg", "没有登录，请登录");
        	return new ModelAndView("/before/login", model);
       }else{  
        	return new ModelAndView("/error/error", model);  
        }  
	}
}
