package com.company.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Comment;
import com.company.bean.User;
import com.company.dao.ICommentDao;
import com.company.dao.IUserDao;
import com.company.dao.impl.CommentDaoImpl;
import com.company.dao.impl.UserDaoImpl;
import com.company.service.ICommentService;
import com.company.vo.CommentVO;

/**
 * @category 评论的业务逻辑实现
 * @author 张杨
 *
 */

public class CommentServiceImpl implements ICommentService{
	
	ICommentDao commentDao = new CommentDaoImpl();
	
	@Test
	public void test(){
		
		System.out.println(find(1).size());
	}
	
	@Override
	public boolean delete(int id) {
		
		return commentDao.delete(id) > 0? true:false;
	}
	@Override
	public List<CommentVO> find(int gid) {
		List<Comment> comments = commentDao.find(gid);
		List<CommentVO> commentVOs = new ArrayList<>();
		IUserDao userDao = new UserDaoImpl();
		User user = null;
		for (Comment comment : comments) {
			CommentVO commentVO = new CommentVO();
			user = userDao.find(comment.getUid());
			commentVO.setId(comment.getId());
			commentVO.setUid(comment.getUid());
			commentVO.setGid(comment.getGid());
			commentVO.setUserName(user.getName());
			commentVO.setContent(comment.getContent());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateTimeStr = sdf.format(comment.getDatetime().getTime());
			commentVO.setDateTimeStr(dateTimeStr);
			commentVOs.add(commentVO);
		}
		return commentVOs;
	}
	
	@Override
	public boolean save(int uid, int gid, String content) {
		
		int uid_int = Integer.valueOf(uid);
		int gid_int = Integer.valueOf(gid);
		Comment comment = new Comment(uid_int,gid_int,content);
		return 	commentDao.save(comment)>0?true:false;
	}
	@Override
	public int findCommentSumNum(int gid) {
		
		return (commentDao.find(gid).size());
	}
	
}
