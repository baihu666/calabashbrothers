package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.Goodsinfo;
import com.company.bean.Goodskind;
import com.company.service.IGoodsinfoService;
import com.company.service.IGoodskindService;
import com.company.service.impl.GoodsinfoServiceImpl;
import com.company.service.impl.GoodskindServiceImpl;

/**
 * @author Vimi
 * @category 商品详情控制器
 */
@WebServlet("/goodsinfo.action")
public class GoodsInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsInfoAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IGoodsinfoService goodsinfoService = new GoodsinfoServiceImpl();
		IGoodskindService goodskindService = new GoodskindServiceImpl();
		//接收商品id
		String idStr = request.getParameter("id");
		if(idStr!=null&&!idStr.equals("")){
			int id = Integer.valueOf(idStr);
			//调用业务逻辑方法，得到商品对象
			Goodsinfo goodsinfo = goodsinfoService.find(id);
			Goodskind goodskind = goodskindService.find(goodsinfo.getKid());
			//放到作用域中
			request.setAttribute("goodsinfo", goodsinfo);
			request.setAttribute("goodskind", goodskind);
			//转发
			request.getRequestDispatcher("goodsinfo.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
