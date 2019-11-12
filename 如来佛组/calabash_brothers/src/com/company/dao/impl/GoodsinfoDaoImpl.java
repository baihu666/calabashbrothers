package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Goodsinfo;
import com.company.dao.IGoodsinfoDao;

/**
 * @author Vimi
 * @category 商品数据访问实现类
 */
public class GoodsinfoDaoImpl extends BaseDao implements IGoodsinfoDao {
	
	

	@Override
	public List<Goodsinfo> findList() {
		List<Goodsinfo> list = new ArrayList<Goodsinfo>();
		try {
			super.regist();
			super.connection();
			String sql = "select * from goodsinfo";
			super.getPst(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Goodsinfo goodsinfo = new Goodsinfo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9));
				list.add(goodsinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return list;
	}
	
	@Override
	public List<Goodsinfo> findKindList(int kid) {
		List<Goodsinfo> list = new ArrayList<Goodsinfo>();
		try {
			super.regist();
			super.connection();
			String sql = "select * from goodsinfo where kid=?";
			super.getPst(sql);
			pstmt.setInt(1, kid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Goodsinfo goodsinfo = new Goodsinfo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9));
				list.add(goodsinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return list;
	}

	@Override
	public List<Goodsinfo> findList(int uid) {
		List<Goodsinfo> list = new ArrayList<Goodsinfo>();
		try {
			super.regist();
			super.connection();
			String sql = "select * from goodsinfo where uid=?";
			super.getPst(sql);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Goodsinfo goodsinfo = new Goodsinfo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9));
				list.add(goodsinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return list;
	}

	@Override
	public Goodsinfo find(int id) {
		Goodsinfo goodsinfo = null;
		try {
			super.regist();
			super.connection();
			String sql = "select * from goodsinfo where id=?";
			super.getPst(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				goodsinfo = new Goodsinfo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return goodsinfo;
	}
	@Test
	public void test(){
		System.out.println(find(1).getName());
	}
	@Override
	public int add(Goodsinfo goodsinfo) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "insert into goodsinfo (kid,name,`desc`,price,`count`,weight,imgSrc,uid) values (?,?,?,?,?,?,?,?)";
			super.getPst(sql);
			pstmt.setInt(1, goodsinfo.getKid());
			pstmt.setString(2, goodsinfo.getName());
			pstmt.setString(3, goodsinfo.getDesc());
			pstmt.setString(4, goodsinfo.getPrice());
			pstmt.setInt(5, goodsinfo.getCount());
			pstmt.setString(6, goodsinfo.getWeight());
			pstmt.setString(7, goodsinfo.getImgSrc());
			pstmt.setInt(8, goodsinfo.getUid());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
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
			String sql = "delete from goodsinfo where id=?";
			super.getPst(sql);
			pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return i;
	}

	@Override
	public int update(Goodsinfo goodsinfo) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "update goodsinfo set kid=?,name=?,`desc`=?,price=?,`count`=?,weight=? where id=?";
			super.getPst(sql);
			pstmt.setInt(1, goodsinfo.getKid());
			pstmt.setString(2, goodsinfo.getName());
			pstmt.setString(3, goodsinfo.getDesc());
			pstmt.setString(4, goodsinfo.getPrice());
			pstmt.setInt(5, goodsinfo.getCount());
			pstmt.setString(6, goodsinfo.getWeight());
			pstmt.setInt(7, goodsinfo.getId());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return i;
	}

	@Override
	public int updateImg(int id, String imgSrc) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "update goodsinfo set imgSrc=? where id=?";
			super.getPst(sql);
			pstmt.setString(1, imgSrc);
			pstmt.setInt(2, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return i;
	}

}
