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
 * @category 首页控制器
 */
@WebServlet("/index.action")
public class IndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IGoodsinfoService goodsinfoServcie = new GoodsinfoServiceImpl();
		//调用方法得到列表
		List<GoodsinfoVO> list1 = goodsinfoServcie.findKindList(1);
		List<GoodsinfoVO> list2 = goodsinfoServcie.findKindList(2);
		List<GoodsinfoVO> list3 = goodsinfoServcie.findKindList(3);
		List<GoodsinfoVO> list4 = goodsinfoServcie.findKindList(4);
		//将列表传到作用域
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		//转发
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
