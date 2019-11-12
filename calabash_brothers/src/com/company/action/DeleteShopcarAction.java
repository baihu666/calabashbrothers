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
 * @category 删除购物车商品控制器(id)
 */
@WebServlet("/deleteShopcar.action")
public class DeleteShopcarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteShopcarAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建业务逻辑对象
		IShopcarService shopcarService=new ShopcarServiceImpl();
		//获取参数
		String idStr=request.getParameter("id");
		int id=Integer.valueOf(idStr);
		//调用业务逻辑方法
		boolean flag=shopcarService.delate(id);
		//判断
		 if(flag){
			//转发
			 request.getRequestDispatcher("showshoplist.action").forward(request, response);
		 }else{
			 request.getRequestDispatcher("404.html").forward(request, response);
		 }
		 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
