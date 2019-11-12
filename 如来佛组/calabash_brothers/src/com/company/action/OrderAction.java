package com.company.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.Goodsinfo;
import com.company.bean.Order;
import com.company.bean.User;
import com.company.dao.IGoodsinfoDao;
import com.company.dao.impl.GoodsinfoDaoImpl;
import com.company.service.IOrderService;
import com.company.service.impl.OrderServiceImpl;
import com.company.vo.OrderVO;

import net.sf.json.JSONObject;

/**
 * @author 张游
 * @category 订单状态控制器
 */
@WebServlet(description = "订单状态控制器", urlPatterns = { "/order.action" })
public class OrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取写出流对象
		IGoodsinfoDao goodsinfoDao = new GoodsinfoDaoImpl();
		// 创建业务逻辑层对象
		IOrderService orderService = new OrderServiceImpl();
		String type = request.getParameter("type");
		if (type.equals("1")) {
			User user = (User) request.getSession().getAttribute("current_user");
			List<OrderVO> listVO = orderService.findVO(user.getId());
			request.setAttribute("listVO", listVO);
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}
		if (type.equals("2")) {
			User user = (User) request.getSession().getAttribute("current_user");
			int status = Integer.valueOf(request.getParameter("status"));
			List<OrderVO> listVO = orderService.findVO(user.getId(), status);
			request.setAttribute("listVO", listVO);
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}
		if (type.equals("20")) {
			// 从前端获得参数
			int type2 = Integer.valueOf(type);
			int gid = Integer.valueOf(request.getParameter("oid"));
			User user = (User) request.getSession().getAttribute("current_user");
			int rid = Integer.valueOf(request.getParameter("rid"));
			Goodsinfo goodsinfo = goodsinfoDao.find(gid);
			Order order = new Order(user.getId(), rid, Integer.valueOf(goodsinfo.getPrice()), type2, gid);
			request.setAttribute("goodsinfo", goodsinfo);
			boolean flag = orderService.insert(order);
			if (flag) {
				request.getRequestDispatcher("order.action").forward(request, response);
			} else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}
		if (type.equals("30")) {
			int type3 = Integer.valueOf(type);
			int oid1 = Integer.valueOf(request.getParameter("oid"));
			boolean flag1 = orderService.update(oid1, type3);
			if (flag1) {
				request.getRequestDispatcher("order.action?type=1").forward(request, response);
			} else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}
		if (type.equals("40")) {
			int type4 = Integer.valueOf(type);
			int oid = Integer.valueOf(request.getParameter("oid"));
			boolean flag1 = orderService.update(oid, type4);
			if (flag1) {
				request.getRequestDispatcher("order.action?type=1").forward(request, response);
			} else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}
		if (type.equals("50")) {
			int type4 = Integer.valueOf(type);
			int oid = Integer.valueOf(request.getParameter("oid"));
			boolean flag1 = orderService.update(oid, type4);
			if (flag1) {
				request.getRequestDispatcher("order.action?type=1").forward(request, response);
			} else {
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
