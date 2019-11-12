package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IShopcarService;
import com.company.service.impl.ShopcarServiceImpl;

/**
 * @author xll
 * @category 删除控制器（gid）
 */
@WebServlet("/deleteShopcarBygid.action")
public class DeleteShopcarBygidAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteShopcarBygidAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IShopcarService shopcarService=new ShopcarServiceImpl();
		//得到gid
		String gidStr=request.getParameter("gid");
		//调用业务逻辑方法
		int gid=Integer.valueOf(gidStr);
		boolean flag=shopcarService.deleteByGood(gid);
		//判断
		if(flag){
			//转发
			response.sendRedirect("showshoplist.action");
			//request.getRequestDispatcher("showshoplist.action").forward(request, response);
		}else{
			request.getRequestDispatcher("404.html").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
