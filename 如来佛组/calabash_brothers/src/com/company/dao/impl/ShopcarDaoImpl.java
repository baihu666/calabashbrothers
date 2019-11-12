package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.bean.Shopcar;
import com.company.dao.IShopcarDao;

/**
 * @author xll
 * @category 购物车
 */
public class ShopcarDaoImpl extends BaseDao implements IShopcarDao {

	@Override
	public List<Shopcar> findAll(int uid) {
		List<Shopcar> list=new ArrayList<Shopcar>();
		regist();
		connection();
		String sql="select * from shopcar where uid=?";
		getPst(sql);
		try {
			pstmt.setInt(1, uid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Shopcar shopcar=new Shopcar(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4));
				list.add(shopcar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		
		return list;
	}

	@Override
	public int add(Shopcar shopcar) {
		int i=0;
		regist();
		connection();	
		String sql="insert into shopcar (gid,uid,ccount) values(?,?,?) ";
		getPst(sql);
		try {
			pstmt.setInt(1, shopcar.getGid());
			pstmt.setInt(2, shopcar.getUid());
			pstmt.setInt(3, shopcar.getCcount());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}	
		return i;
	
	}

	@Override
	public Shopcar find(int id) {
		Shopcar shopcar=null;
		regist();
		connection();
		String sql="select * from shopcar where id=?";
		getPst(sql);
		try {
			pstmt.setInt(1, id);	
			rs=pstmt.executeQuery();
			while(rs.next()){
				shopcar=new Shopcar(rs.getInt(1), rs.getInt(2), rs.getInt(3),rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}	
		return shopcar;
	}

	@Override
	public int delete(int id) {
		int i=0;
		regist();
		connection();	
		String sql="delete from shopcar where id=? ";
		getPst(sql);
		try {
			pstmt.setInt(1, id);
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}	
		return i;
	}

	@Override
	public int update(Shopcar shopcar) {
		int i=0;
		regist();
		connection();	
		String sql="update shopcar set uid=?,gid=?,ccount=? where id=? ";
		getPst(sql);
		try {
			pstmt.setInt(1, shopcar.getUid());
			pstmt.setInt(2, shopcar.getGid());
			pstmt.setInt(3, shopcar.getCcount());
			pstmt.setInt(4, shopcar.getId());	
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}	
		return i;
	}
	@Override
	public int deleteByUser(int uid) {
		int i=0;
		regist();
		connection();	
		String sql="delete from shopcar where uid=? ";
		getPst(sql);
		try {
			pstmt.setInt(1, uid);
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}	
		return i;
	}

	@Override
	public int deleteByGood(int gid) {
		int i=0;
		regist();
		connection();	
		String sql="delete from shopcar where gid=? ";
		getPst(sql);
		try {
			pstmt.setInt(1, gid);
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}	
		return i;
		
	}

}
