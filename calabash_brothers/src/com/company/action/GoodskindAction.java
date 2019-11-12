package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.Goodskind;
import com.company.service.IGoodskindService;
import com.company.service.impl.GoodskindServiceImpl;

/**
 * @author hzm
 * @category 商品种类控制器
 *
 */
@WebServlet("/goodskind.action")
public class GoodskindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GoodskindAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IGoodskindService goodskindService = new GoodskindServiceImpl();
		//接收商品id
		String idStr = request.getParameter("id");
		if (idStr!=null&!idStr.equals("")) {
		
			int id = Integer.valueOf(idStr);
			//找到商品id
			Goodskind goodskind = goodskindService.find(id);
			request.setAttribute("goodskind", goodskind);
			//转发到页面
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else{
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
