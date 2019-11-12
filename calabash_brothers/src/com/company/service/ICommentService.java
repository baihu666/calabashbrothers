package com.company.service;

import java.util.List;

import com.company.vo.CommentVO;

/**
 * @author zhangyang
 * @category 评论的业务逻辑层
 */
public interface ICommentService {

	/**
	 * 保存 评论信息
	 * @param comment
	 * @return
	 */
	public boolean save(int uid,int gid,String content);
	
	/**
	 * 删除评论
	 * @param id 评论的id
	 * @return
	 */
	public boolean delete(int id);
	
	/**
	 * 查询评论列表
	 * @param  商品gid
	 * @return
	 */
	public List<CommentVO> find(int gid);
	/**
	 * 查询评论的条数
	 * @param gid
	 * @return
	 */
	public int findCommentSumNum(int gid);
	
}
