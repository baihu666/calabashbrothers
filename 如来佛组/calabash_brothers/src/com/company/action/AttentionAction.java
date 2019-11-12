package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.bean.Attention;
import com.company.bean.User;
import com.company.service.IAttentionService;
import com.company.service.impl.AttentionServiceImpl;
import com.company.vo.AttentionVO;

/**
 * @author 张游
 * @category 关注的控制器  type 1:添加关注
 */
@WebServlet(description = "关注的控制器", urlPatterns = { "/attention.action" })
public class AttentionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AttentionAction() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建业务逻辑对象
		IAttentionService attentionService=new AttentionServiceImpl();
		//接收前段数据
		String type=request.getParameter("type");
		User user=(User)request.getSession().getAttribute("current_user");
		if(type.equals("1")){
			 List<AttentionVO> listVO=attentionService.findAll(user.getId());
			 request.setAttribute("listVO", listVO);
			 request.getRequestDispatcher("attention1.jsp").forward(request, response);
		}
		if(type.equals("2")){
			//接收前段数据
			int gid=Integer.valueOf(request.getParameter("gid"));
			//创建关注对象
			Attention attention=new Attention(user.getId(), gid);
			boolean flag=attentionService.addAttention(attention);
			if(flag){
				request.getRequestDispatcher("attention.action?type=1").forward(request, response);
			}else{
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}
		if(type.equals("3")){
			//接收前段数据
			int attentionid=Integer.valueOf(request.getParameter("aid"));
			boolean flag=attentionService.deleteAttention(attentionid);
			if(flag){
				request.getRequestDispatcher("attention.action?type=1").forward(request, response);
			}else{
				request.getRequestDispatcher("404.jsp").forward(request, response);
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}















