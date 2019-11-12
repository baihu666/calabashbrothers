package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.User;
import com.company.service.IShopcarService;
import com.company.service.IUserService;
import com.company.service.impl.ShopcarServiceImpl;
import com.company.service.impl.UserServiceImpl;

/**
 * @author xll
 * @category 支付控制器
 */
@WebServlet("/pay.action")
public class PayAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PayAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IShopcarService shopcarService = new ShopcarServiceImpl();
		IUserService userService = new UserServiceImpl();

		// 获取参数
		String money = request.getParameter("money");
		System.out.println(money);
		String idStr = request.getParameter("id");
		idStr = idStr.substring(0, idStr.length() - 1);

		String[] id = idStr.split("/");

		// 获得用户id
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("current_user");
		boolean flag1 = false;
		boolean flag2 = false;
		if (obj != null) {
			User user = (User) obj;
			int uid = user.getId();
			flag1 = userService.updateMoney(uid, money, false);
			flag2 = userService.updateIntegral(uid, money, true);

			if (flag1 && flag2) {
				for (int i = 0; i < id.length; i++) {
					int b = Integer.valueOf(id[i]);
					shopcarService.delate(b);
					/*
					 * if (flag) { json.put("flag", flag); } else {
					 * response.sendRedirect("404.jsp"); }
					 */
				}
				request.getRequestDispatcher("showshoplist.action").forward(request, response);
			} else {
				request.setAttribute("mes", "余额不足");
				request.getRequestDispatcher("showshoplist.action").forward(request, response);
			}
		} else {
			response.sendRedirect("404.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
