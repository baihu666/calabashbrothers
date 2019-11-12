package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.Goodsinfo;
import com.company.bean.Order;
import com.company.bean.User;
import com.company.service.IGoodsinfoService;
import com.company.service.IOrderService;
import com.company.service.impl.GoodsinfoServiceImpl;
import com.company.service.impl.OrderServiceImpl;

/**
 * @author 张游
 */
@WebServlet("/createorder.action")
public class CreateOrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateOrderAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IOrderService orderService = new OrderServiceImpl();
		IGoodsinfoService goodsinfoService = new GoodsinfoServiceImpl();
		User user = (User) request.getSession().getAttribute("current_user");
		String ridStr = request.getParameter("addressId");
		String gidStr = request.getParameter("gid");
		int rid = Integer.valueOf(request.getParameter("addressId"));
		int gid = Integer.valueOf(request.getParameter("gid"));
		Goodsinfo goodsinfo = goodsinfoService.find(gid);
		Order order = new Order(user.getId(), rid, Integer.valueOf(goodsinfo.getPrice()), 20, gid);
		int money = user.getMoney();
		int price = Integer.valueOf(goodsinfo.getPrice());
		boolean flag = orderService.insert(order);
		if (flag) {
			if (money >= price) {
				request.getRequestDispatcher("order.action?type=1").forward(request, response);
			} else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
