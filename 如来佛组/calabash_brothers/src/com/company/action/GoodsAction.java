package com.company.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.Goodskind;
import com.company.service.IGoodsinfoService;
import com.company.service.IGoodskindService;
import com.company.service.impl.GoodsinfoServiceImpl;
import com.company.service.impl.GoodskindServiceImpl;
import com.company.vo.GoodsinfoVO;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GoodsAction
 */
@WebServlet("/goods.action")
public class GoodsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GoodsAction() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IGoodskindService goodskindService = new GoodskindServiceImpl();
		IGoodsinfoService goodsinfoService = new GoodsinfoServiceImpl();
		String type = request.getParameter("type");
		JSONObject json = new JSONObject();
		if (type.equals("1")) {
			System.out.println("管理界面列表");
			List<Goodskind> klist = new ArrayList<Goodskind>();
			klist = goodskindService.findAll();
			json.put("klist", klist);
		} else if(type.equals("2")){
			List<GoodsinfoVO> list = goodsinfoService.findList();
			json.put("list", list);
		}

		response.getWriter().print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
