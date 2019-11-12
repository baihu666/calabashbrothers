package com.company.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.ICommentService;
import com.company.service.impl.CommentServiceImpl;
import com.company.vo.CommentVO;

import net.sf.json.JSONObject;

/**
 * @author zhangyang
 * @category 评论控制器 type:1,查询该商品下的所有评论 2，保存评论 3，删除评论
 */
@WebServlet("/comment.action")
public class CommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ICommentService commentService = new CommentServiceImpl();
		String type = request.getParameter("type");
		JSONObject json = new JSONObject();
		if (type.equals("1")) {
			int bid = Integer.valueOf(request.getParameter("bid"));
			List<CommentVO> list = commentService.find(bid);
			System.out.println(list);
			json.put("list", list);
		} else if (type.equals("2")) {
			int gid = Integer.valueOf(request.getParameter("gid"));
			int uid = Integer.valueOf(request.getParameter("uid"));
			String content = request.getParameter("content");
			boolean flag = commentService.save(uid, gid, content);
			json.put("flag", flag);
		} else if (type.equals("3")) {
			int id = Integer.valueOf(request.getParameter("id"));
			boolean flag = commentService.delete(id);
			json.put("flag", flag);
		}
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
