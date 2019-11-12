package com.company.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.ReceivingInformation;
import com.company.dao.IReceivingInfoDao;

public class ReceivingInfoDaoImpl extends BaseDao implements IReceivingInfoDao {
	@Test
	public void test(){
		/*ReceivingInformation rinfo=new ReceivingInformation("张新虎", "1324453111", "渭南市", "三中村", 2);
		System.out.println(save(rinfo));*/
		/*System.out.println(update(rinfo)); */
		/*System.out.println("删除结果");
		System.out.println(delete(2));*/
		/*System.out.println(find(1));*/
		/*System.out.println(findAll(2).size());*/
	}

	@Override
	public int save(ReceivingInformation rinfo) {
		int i=0;
		try {
			super.regist();
			super.connection();
			String sql="insert into receivinginformation(rusername,tel,area,addres,uid) values(?,?,?,?,?)";
			super.getPst(sql);
			super.pstmt.setString(1, rinfo.getRusername());
			super.pstmt.setString(2, rinfo.getTel());
			super.pstmt.setString(3, rinfo.getArea());
			super.pstmt.setString(4, rinfo.getAddres());
			super.pstmt.setInt(5, rinfo.getUid());
			i=super.pstmt.executeUpdate();//增加一个新的用户
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return i;
	}
	@Override
	public int delete(int id) {
		int i=0;
		super.regist();
		super.connection();
		String sql="delete from receivinginformation where id=?";
		super.getPst(sql);
		try {
			super.pstmt.setInt(1, id);
			i=super.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return i;
	}
	@Override
	public ReceivingInformation find(int id) {
		ReceivingInformation rinfo=null;
		super.regist();
		super.connection();
		String sql="select * from receivinginformation where id=?";
		super.getPst(sql);
		try {
			super.pstmt.setInt(1, id);
			ResultSet rs=super.pstmt.executeQuery();
			while(rs.next()){//必须用rs.next()方法遍历
			rinfo =new ReceivingInformation(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5), rs.getInt(6)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return rinfo;
	}

	@Override
	public List<ReceivingInformation> findAll(int uid) {
		List<ReceivingInformation> list=new ArrayList<>();
		super.regist();
		super.connection();
		String sql="select * from receivinginformation where uid=?";
		super.getPst(sql);
		try {
			super.pstmt.setInt(1, uid);
			rs=super.pstmt.executeQuery();
			while(rs.next()){
				ReceivingInformation rinfo =new ReceivingInformation(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getString(5), rs.getInt(6));
				list.add(rinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int update(ReceivingInformation rinfo) {
		int i=0;
		try {
			super.regist();
			super.connection();
			String sql="update receivinginformation set rusername=?,tel=?,area=?,addres=?,uid=? where id=?";
			super.getPst(sql);
			super.pstmt.setString(1, rinfo.getRusername());
			super.pstmt.setString(2, rinfo.getTel());
			super.pstmt.setString(3, rinfo.getArea());
			super.pstmt.setString(4, rinfo.getAddres());
			super.pstmt.setInt(5, rinfo.getUid());
			super.pstmt.setInt(6, rinfo.getId());
			System.out.println("daozhele !");
			i=super.pstmt.executeUpdate();//更新用户
			System.out.println("daozhele 2");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.close();
		}
		return i;
	}
}
