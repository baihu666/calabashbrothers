package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.User;
import com.company.service.IAreaService;
import com.company.service.ICityService;
import com.company.service.IProvinceService;
import com.company.service.IUserService;
import com.company.service.impl.AreaServiceImpl;
import com.company.service.impl.CityServiceImpl;
import com.company.service.impl.ProvinceServiceImpl;
import com.company.service.impl.UserServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateUserAction
 */
@WebServlet("/updateuser.action")
public class UpdateUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建逻辑对象
	
		IUserService userService = new UserServiceImpl();
		IProvinceService provinceService = new ProvinceServiceImpl();
		ICityService cityService = new CityServiceImpl();
		IAreaService areaService = new AreaServiceImpl();
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("current_user");
		int id = user.getId();
		request.getRemoteAddr();
		request.getLocalAddr();
		System.out.println(request.getRemoteAddr());
		
		System.out.println(id);
		if (type.equals("1")) {
			String headimg = UploadImag.headUpload(this.getServletConfig(), request, response);
			System.out.println(headimg);
			boolean flag = userService.updateHeadimg(id, headimg);
			user.setHeadimg(headimg);
			session.setAttribute("current_user", user);
			if (flag) {
				request.setAttribute("img", headimg);
				request.getRequestDispatcher("updateUserInfo.jsp").forward(request, response);
			} else {
				request.setAttribute("img", "照片上传失败");
				request.getRequestDispatcher("updateUserInfo.jsp").forward(request, response);
			}
		}else if (type.equals("2")) {
			// 获得各项值
			String name = request.getParameter("userName");
			System.out.println(name);
			String pass = request.getParameter("password");
			String sex = request.getParameter("sex");
			String age = request.getParameter("age");
			String tel = request.getParameter("tel");
			// 接收地址并合并
			String priID = request.getParameter("province");
			String cityID = request.getParameter("city");
			String areaID = request.getParameter("area");
			String province = provinceService.findObject(priID).getProvince();
			String city = cityService.findObject(cityID).getCity();
			String area = areaService.findObject(areaID).getArea();
			String jiedao = request.getParameter("jiedao");
			String addr = province + city + area + jiedao;
			int age_int = Integer.valueOf(age);
			User user1 = new User(id,name,pass,sex,age_int,addr,tel);
			boolean flag = userService.update(user1);
			if (flag) {
				response.sendRedirect("goodslist.action");
			} else {
				response.sendRedirect("updateUserInfo.jsp");
			}
			System.out.println(flag);
		}else{
			System.out.println("其他");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
