package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.IGoodsinfoService;
import com.company.service.impl.GoodsinfoServiceImpl;
import com.company.vo.GoodsinfoVO;

/**
 * @author Vimi
 * @category 展示商品列表控制器
 */
@WebServlet("/goodslist.action")
public class GoodsListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsListAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IGoodsinfoService goodsinfoService = new GoodsinfoServiceImpl();
		//接收商品类型的字符串
		String kidStr = request.getParameter("kid");
		//定义列表集合
		List<GoodsinfoVO> list = null;
		//判断是否为空
		if(kidStr==null){
			System.out.println("商品列表");
			list = goodsinfoService.findList();
		}else{
			int kid = Integer.valueOf(kidStr);
			list = goodsinfoService.findKindList(kid);
		}
		//将列表放入作用域中
		request.setAttribute("list", list);
		//转发到相应页面
		request.getRequestDispatcher("goodskind.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
