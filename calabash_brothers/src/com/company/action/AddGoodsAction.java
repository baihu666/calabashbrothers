package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.Goodskind;
import com.company.bean.User;
import com.company.service.IGoodsinfoService;
import com.company.service.IGoodskindService;
import com.company.service.impl.GoodsinfoServiceImpl;
import com.company.service.impl.GoodskindServiceImpl;

/**
 * @author Vimi
 * @category 添加商品控制器
 */
@WebServlet("/addgoods.action")
public class AddGoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddGoodsAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("current_user");
		if (obj != null) {
			User user = (User) obj;
			System.out.println(0123);
			// 创建业务逻辑对象
			IGoodsinfoService goodsinfoService = new GoodsinfoServiceImpl();
			IGoodskindService goodskindService = new GoodskindServiceImpl();
			// 获取type值
			String type = request.getParameter("type");
			// 根据type值进行判断
			if (type.equals("1")) {
				// 调用业务逻辑对象方法取到商品分类列表
				List<Goodskind> goodskindList = goodskindService.findAll();
				// 将列表放入作用域中
				request.setAttribute("goodskindList", goodskindList);
				// 转发到商品添加页面中
				request.getRequestDispatcher("addgoods.jsp").forward(request, response);
			} else if (type.equals("2")) {
				// 接收商品信息
				String kind = request.getParameter("kind");
				String name = request.getParameter("name");
				String desc = request.getParameter("desc");
				String price = request.getParameter("price");
				String countStr = request.getParameter("count");
				String weight = request.getParameter("weight");
				int count = Integer.valueOf(countStr);
				// 调用业务逻辑方法,根据返回值结果响应
				boolean flag = goodsinfoService.add(kind, name, desc, price, count, weight, "image/彭于晏.jpg",user.getId());
				if (flag) {
					request.getRequestDispatcher("index.action").forward(request,response);
				} else {
					request.getRequestDispatcher("404.jsp").forward(request, response);
				}
			} 
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
