package com.company.dao;

import java.util.List;

import com.company.bean.Comment;

/**
 * 
 * @author zhangyang
 * @category  评论的数据访问层接口
 */

public interface ICommentDao {
	/**
	 * 保存评论信息
	 * @param comment
	 * @return
	 */
	public int save(Comment comment);
	/**
	 * 删除评论
	 * @param id 评论的id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 删除评论
	 * @param gid 商品的id
	 * @return
	 */
	public int deleteBygid(int gid);
	/**
	 * 删除评论
	 * @param  用户的id
	 * @return
	 */
	public int deleteByUserId(int uid);
	/**
	 * 查询评论列表
	 * @param gId 商品的id
	 * @return
	 */
	public List<Comment> find(int gid);
	
}
