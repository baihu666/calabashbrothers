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

import net.sf.json.JSONObject;

/**
 * @author xll
 * @category 更新购物车控制器
 */
@WebServlet("/updateShopcar.action")
public class UpdateShopcarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateShopcarAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //创建业务逻辑对象
		IShopcarService shopcarService=new ShopcarServiceImpl();
		
		//得到购物车参数
		HttpSession session=request.getSession();
		String idStr=request.getParameter("id");
		Object obj=session.getAttribute("current_user");
		String gidStr=request.getParameter("gid");
		String ccountStr=request.getParameter("ccount");
		JSONObject json=new JSONObject();
		//判断当前用户
		if(obj!=null){
			User user=(User)obj;
			int gid=Integer.valueOf(gidStr);
			int id=Integer.valueOf(idStr);
			int ccount=Integer.valueOf(ccountStr);
			//调用业务逻辑方法v
			boolean flag=shopcarService.update(id, gid, user.getId(), ccount);
			//判断
			json.put("flag",flag );
		}else{
			//转发到登录页面
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
