package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IOrderService;
import com.company.service.impl.OrderServiceImpl;

/**
 * @author 删除订单控制器
 */
@WebServlet("/deleteorder.action")
public class DeleteOrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteOrderAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IOrderService orderService=new OrderServiceImpl();
		int oid=Integer.valueOf(request.getParameter("oid"));
		boolean flag = orderService.cancel(oid);
		if (flag) {
			request.getRequestDispatcher("order.action?type=1").forward(request, response);
		} else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
