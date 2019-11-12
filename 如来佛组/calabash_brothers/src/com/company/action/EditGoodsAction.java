package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.bean.Goodsinfo;
import com.company.bean.Goodskind;
import com.company.bean.User;
import com.company.service.IGoodsinfoService;
import com.company.service.IGoodskindService;
import com.company.service.impl.GoodsinfoServiceImpl;
import com.company.service.impl.GoodskindServiceImpl;

/**
 * @author Vimi
 * @category 编辑商品控制器
 * @category type：1 删除商品	2：准备编辑	3：保存编辑
 */
@WebServlet("/editgoods.action")
public class EditGoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditGoodsAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IGoodsinfoService goodsinfoService = new GoodsinfoServiceImpl();
		IGoodskindService goodskindService = new GoodskindServiceImpl();
		//获取type
		String type = request.getParameter("type");
		//获取当前用户对象
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("current_user");
		//获取商品id
		String idStr = request.getParameter("id");
		int id = Integer.valueOf(idStr);
		if(obj!=null){
			User user = (User)obj;
			if(type.equals("1")){
				boolean flag = goodsinfoService.delete(id);
				if(flag){
					response.sendRedirect("index.action");
				}else{
					request.getRequestDispatcher("404.jsp").forward(request, response);
				}
			}else if(type.equals("2")){
				Goodsinfo goodsinfo = goodsinfoService.find(id);
				List<Goodskind> goodskind = goodskindService.findAll();
				request.setAttribute("goodsinfo", goodsinfo);
				request.setAttribute("goodskind", goodskind);
				request.getRequestDispatcher("updategoods.jsp").forward(request, response);
			}else if(type.equals("3")){
				Goodsinfo goodsinfo = goodsinfoService.find(id);
				String picture = UploadImag.headUpload(this.getServletConfig(), request, response);
				boolean flag = goodsinfoService.update(id, picture);
				Goodsinfo goodsinfo2 = goodsinfoService.find(id);
				request.setAttribute("goodsinfo", goodsinfo2);
				if(flag){
					request.getRequestDispatcher("updategoods.jsp").forward(request, response);
				}
			} else if(type.equals("4")){
				String kind = request.getParameter("kind");
				String name = request.getParameter("name");
				String desc = request.getParameter("desc");
				String price = request.getParameter("price");
				String countStr = request.getParameter("count");
				int count = Integer.valueOf(countStr);
				String weight = request.getParameter("weight");
				boolean flag = goodsinfoService.update(id, kind, name, desc, price, count, weight);
				if(flag){
					response.sendRedirect("persongoodslist.action?uid="+user.getId());
				}else{
					request.getRequestDispatcher("404.jsp").forward(request, response);
				}
			}else{
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("goodslist.action").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
