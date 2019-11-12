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
 * @category 添加购物车控制器
 */
@WebServlet("/addShopcar.action")
public class AddShopcarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddShopcarAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
		//创建业务逻辑对象
		IShopcarService shopcarService=new ShopcarServiceImpl();
	    //得到购物车参数
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("current_user");
		String gidStr=request.getParameter("gid");
		String ccountStr=request.getParameter("ccount");
		if(obj!=null){
			User user=(User)obj;
			int gid=Integer.valueOf(gidStr);
			int ccount=Integer.valueOf(ccountStr);
			//调用业务逻辑方法
			boolean flag=shopcarService.add(gid, user.getId(), ccount);
			//根据结果转发
			if(flag){
				response.sendRedirect("showshoplist.action");
			}else{
				request.getRequestDispatcher("404.html").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
