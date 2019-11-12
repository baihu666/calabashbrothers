package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.User;
import com.company.service.IUserService;
import com.company.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterAction
 */
/**
 * @author rjw
 * @category 注册
 *
 */
@WebServlet("/register.action")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterAction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService userService = new UserServiceImpl();
		String name = request.getParameter("userName");
		String pass = request.getParameter("password");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String tel = request.getParameter("tel");
		String ip = request.getRemoteAddr();
		int age_int = Integer.valueOf(age);
		User user = new User(name,pass,sex,age_int,tel,ip);
		boolean flag = userService.add(user);
		if (flag) {
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("register.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
