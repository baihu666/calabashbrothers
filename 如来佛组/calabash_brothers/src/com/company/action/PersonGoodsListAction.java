package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.User;
import com.company.service.IGoodsinfoService;
import com.company.service.IUserService;
import com.company.service.impl.GoodsinfoServiceImpl;
import com.company.service.impl.UserServiceImpl;
import com.company.vo.GoodsinfoVO;

/**
 * @author Vimi
 * @category 个人商品列表控制器
 */
@WebServlet("/persongoodslist.action")
public class PersonGoodsListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonGoodsListAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IUserService userService = new UserServiceImpl();
		IGoodsinfoService goodsinfoService = new GoodsinfoServiceImpl();
		//接收用户id
		String uidStr = request.getParameter("uid");
		if(uidStr!=null&&!uidStr.equals("")){
			int uid = Integer.valueOf(uidStr);
			//获得用户
			User user = userService.find(uidStr);
			//获得用户的商品列表
			List<GoodsinfoVO> list = goodsinfoService.findList(uid);
			//将对象放进作用域中
			request.setAttribute("user", user);
			request.setAttribute("list", list);
			System.out.println();
			//转发
			request.getRequestDispatcher("showusergoods.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
