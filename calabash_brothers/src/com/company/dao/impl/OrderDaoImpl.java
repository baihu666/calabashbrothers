package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Order;
import com.company.dao.IOrderDao;

public class OrderDaoImpl extends BaseDao implements IOrderDao {
	@Test
	public void t1(){
		/*System.out.println("123");
		Order order=new Order(1, 1, 111, 10, 2);
		System.out.println(insert(order));*/
		/*System.out.println(selectByOrderNo(1));*/
		/*System.out.println(find(1).size());*/
		System.out.println(update(1, 20));
	}

	@Override
	public Order selectByOrderNo(int orderNo) {
		Order order=null;
		try {
			super.regist();
			super.connection();
			String sql = "select * from `Order` where id = ?";
			super.getPst(sql);
			super.pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				order = new Order(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return order;
	}

	@Override
	public int insert(Order order) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "insert into `order`(uid,rid,totalprice,`status`,gid) values(?,?,?,?,?)";
			super.getPst(sql);
			super.pstmt.setInt(1, order.getUid());
			super.pstmt.setInt(2, order.getRid());
			super.pstmt.setInt(3, order.getTotalprice());
			super.pstmt.setInt(4, order.getStatus());
			super.pstmt.setInt(5, order.getGid());
			i = super.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return i;
	}
	@Override
	public List<Order> find(int uid) {
		List<Order> list=new ArrayList<Order>();
		try {
			super.regist();
			super.connection();
			String sql = "select * from `Order` where uid = ?";
			super.getPst(sql);
			super.pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

	@Override
	public int cancel(int id) {
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "delete from `Order` where id =? ";
			super.getPst(sql);
			super.pstmt.setInt(1, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return i;
	}

	@Override
	public int update(int id, int status){//根据订单id
		int i = 0;
		try {
			super.regist();
			super.connection();
			String sql = "update `Order` set `status`=? where id=?";
			super.getPst(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, id);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			super.close();
		}
		return i;
	}

	@Override
	public List<Order> find(int uid, int status) {
		List<Order> list=new ArrayList<Order>();
		try {
			super.regist();
			super.connection();
			String sql = "select * from `Order` where uid = ? and status=?";
			super.getPst(sql);
			super.pstmt.setInt(1, uid);
			super.pstmt.setInt(2, status);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	};
}
