package com.company.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Attention;
import com.company.dao.IAttentionDao;

/**
 * @author Administrator
 * @category 关注的数据访问实现类
 */
public class AttentionDaoImpl extends BaseDao implements IAttentionDao{
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	@Test
	public void test(){
		/*System.out.println("看看有几条");
		System.out.println(findAll(1).size());*/
		System.out.println(deleteAttention(1));
	}
	@Override
	public List<Attention> findAll(int uid) {
		List<Attention> list=new ArrayList<>();
		try {
			super.regist();
			super.connection();
			String sql="select * from `attention` where uid=?";
			super.getPst(sql);
			super.pstmt.setInt(1, uid);
			rs=super.pstmt.executeQuery();
			while(rs.next()){
				Attention attention=new Attention(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				list.add(attention);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return list;
	}

	@Override
	public int addAttention(Attention attention) {
		int num=0;
		try {
			super.regist();
			super.connection();
			String sql="insert into `attention`(gid,uid) values (?,?)";
			super.getPst(sql);
			super.pstmt.setInt(1, attention.getGid());
			super.pstmt.setInt(2, attention.getUid());
			num=super.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return num;
	}

	@Override
	public int deleteAttention(int id) {
		int num=0;
		try {
			super.regist();
			super.connection();
			String sql="delete from `attention` where id=?";
			super.getPst(sql);
			super.pstmt.setInt(1,id);
			num=super.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return num;
	}
	@Override
	public int deleteByUser(int uid) {
		int num=0;
		try {
			super.regist();
			super.connection();
			String sql="delete from `attention` where uid=?";
			super.getPst(sql);
			super.pstmt.setInt(1,uid);
			num=super.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return num;

	}
	@Override
	public int deleteByGid(int gid) {
		int num=0;
		try {
			super.regist();
			super.connection();
			String sql="delete from `attention` where gid=?";
			super.getPst(sql);
			super.pstmt.setInt(1,gid);
			num=super.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return num;
	}
}
