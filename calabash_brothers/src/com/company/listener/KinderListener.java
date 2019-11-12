package com.company.listener;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.company.bean.Goodskind;
import com.company.service.IGoodskindService;
import com.company.service.impl.GoodskindServiceImpl;

/**
 * @author hzm
 * @category 监听
 *
 */
@WebListener
public class KinderListener implements ServletContextListener {

	public KinderListener() {
	}

	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
		System.out.println("监听器工作：监听application");
		// 创建业务逻辑对象
		IGoodskindService goodskindService = new GoodskindServiceImpl();
		// 得到APP
		ServletContext application = event.getServletContext();
		// 得到商品列表集合
		List<Goodskind> goodskindList = goodskindService.findAll();
		// 将集合放入APP作用域
		application.setAttribute("goodskindList", goodskindList);
	}

}
