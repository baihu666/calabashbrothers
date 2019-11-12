package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.User;
import com.company.service.IReceivingInfoService;
import com.company.service.impl.ReceivingInfoServiceImpl;

/**
 * @author 
 * @category 添加售货地址控制器
 */
@WebServlet("/addraddress.action")
public class AddRAddressAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddRAddressAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type.equals("1")){
			String gidStr=request.getParameter("gid");
			request.setAttribute("gid", gidStr);
			request.getRequestDispatcher("addraddress.jsp").forward(request, response);
		}else if(type.equals("2")){
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String area = request.getParameter("area");
			String area1 = request.getParameter("area");
			int gid=Integer.valueOf(request.getParameter("gid"));
			User user=(User)request.getSession().getAttribute("current_user");
			IReceivingInfoService receivingInfoService=new ReceivingInfoServiceImpl();
			boolean flag=receivingInfoService.save(name, tel, area, area1, user.getId());
			if(flag){
				request.getRequestDispatcher("goodsinfo.action?id="+gid).forward(request, response);
			}
		}
		
		
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
