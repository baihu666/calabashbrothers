package com.company.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.ReceivingInformation;
import com.company.bean.User;
import com.company.service.IReceivingInfoService;
import com.company.service.impl.ReceivingInfoServiceImpl;

import net.sf.json.JSONObject;

/**
 * @author 查询所有地址的控制器
 */
@WebServlet("/selectaddress.action")
public class SelectAddressAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SelectAddressAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//创建json对象
		JSONObject json = new JSONObject();
		User user=(User)request.getSession().getAttribute("current_user");
		IReceivingInfoService receivingInfoService=new ReceivingInfoServiceImpl();
		List<ReceivingInformation> list=receivingInfoService.findAll(user.getId());
		json.put("list", list);
		response.getWriter().println(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

















