package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.User;
import com.company.service.IShopcarService;
import com.company.service.impl.ShopcarServiceImpl;
import com.company.vo.ShopcarVO;

/**
 * @author xll
 * @category 展示购物车控制器
 */
@WebServlet("/showshoplist.action")
public class ShowShopListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowShopListAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //创建业务逻辑对象
		IShopcarService shopcarService=new ShopcarServiceImpl();
		//得到user
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("current_user");
		if(obj!=null){
				User user=(User)obj;
				//调用业务逻辑方法得到集合
				List<ShopcarVO> list= shopcarService.findAll(user.getId());
				//将集合放到request作用域中
				
				request.setAttribute("list", list);
				//转发
			
				request.getRequestDispatcher("pay.jsp").forward(request, response);
			
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
