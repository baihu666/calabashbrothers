package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * Servlet implementation class PayMoneyAction
 */
@WebServlet("/paymoney.action")
public class PayMoneyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PayMoneyAction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		String money = request.getParameter("money");
		System.out.println(money);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
