package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Comment;
import com.company.dao.ICommentDao;

/**
 * 评论数据访问层实现类
 * 
 * @author 张杨
 *
 */

public class CommentDaoImpl extends BaseDao implements ICommentDao {
	@Test
	public void test() {
		// Comment comment = new Comment(1,2,"3",new Date());
		// save(comment);
		// System.out.println(find(1).size());
		System.out.println(deleteByUserId(2));
	}

	@Override
	public int save(Comment comment) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "insert into comment (uid,gid,datetime,content) values (?,?,?,?)";
			super.getPst(sql);
			pstmt.setInt(1, comment.getUid());
			pstmt.setInt(2, comment.getGid());
			pstmt.setObject(3, comment.getDatetime());
			pstmt.setString(4, comment.getContent());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return i;
	}

	@Override
	public int delete(int id) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "delete from comment where id =?";
			super.getPst(sql);
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return i;
	}

	@Override
	public int deleteBygid(int gid) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "delete from comment where gid=?";
			super.getPst(sql);
			pstmt.setInt(1, gid);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}

		return i;
	}

	@Override
	public List<Comment> find(int gId) {
		List<Comment> list = new ArrayList<Comment>();
		super.regist();
		super.connection();
		String sql = "select * from comment where gid=?";
		super.getPst(sql);
		try {
			pstmt.setInt(1, gId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Comment comment = new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getTimestamp(5));
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

	@Override
	public int deleteByUserId(int uid) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "delete from comment where uid=?";
			super.getPst(sql);
			pstmt.setInt(1, uid);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return i;
	}


}
