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
import com.company.service.impl.ShopcarServiceImpl;

/**
 * @author xll
 * @category 删除购物车控制器(uid)
 */
@WebServlet("/deleteShopcarByuid.action")
public class DeleteShopcarByuidAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteShopcarByuidAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建业务逻辑对象
		IShopcarService shopcarService = new ShopcarServiceImpl();
		// 得到gid
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("current_user");
		User user=(User)obj;
		// 调用业务逻辑方法
		boolean flag = shopcarService.deleteByUser(user.getId());
		// 判断
		if (flag) {
			// 转发
			request.getRequestDispatcher("showshoplist.action").forward(request, response);
		} else {
			request.getRequestDispatcher("404.html").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
