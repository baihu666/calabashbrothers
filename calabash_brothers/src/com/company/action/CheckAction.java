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
 * @category 检查控制器
 */
@WebServlet("/check.action")
public class CheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckAction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		String name = request.getParameter("name");
		boolean flag = userService.findByName(name);
		response.getWriter().print(flag);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
