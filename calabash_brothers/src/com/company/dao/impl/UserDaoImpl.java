package com.company.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.bean.User;
import com.company.dao.IUserDao;

/**
 * 
 * @author rjw
 * @category 企业内购用户数据实现类
 *
 */
public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public User find(String name, String pass) {
		User user = null;
		try {
			super.regist();
			super.connection();
			String sql = "select * from User where `name`=? and pass=?";
			super.getPst(sql);
			super.pstmt.setString(1, name);
			super.pstmt.setString(2, pass);
			super.rs = pstmt.executeQuery();
			while (rs.next()) {
				user = createUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return user;
	}

	@Override
	public int add(User user) {
		int num = 0;
		try {
			super.regist();
			super.connection();
			String sql = "INSERT INTO USER(`name`,pass,sex,age,tel,money,integral,headimg)VALUE(?,?,?,?,?,?,?,?)";
			super.getPst(sql);
			super.pstmt.setString(1, user.getName());
			super.pstmt.setString(2, user.getPass());
			super.pstmt.setString(3, user.getSex());
			super.pstmt.setInt(4, user.getAge());
			super.pstmt.setString(5, user.getTel());
			super.pstmt.setInt(6, 0);
			super.pstmt.setInt(7, 0);
			super.pstmt.setString(8, "/img/201910288122648752.jpg");
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return num;
	}

	@Override
	public int update(User user) {
		int num = 0;System.out.println(user.getName());
		try {
			super.regist();
			super.connection();
			String sql = "UPDATE USER SET `name`=?,pass=?,sex=?,age=?,addr=?,tel=? WHERE id=?";
			super.getPst(sql);
			super.pstmt.setString(1, user.getName());
			super.pstmt.setString(2, user.getPass());
			super.pstmt.setString(3, user.getSex());
			super.pstmt.setInt(4, user.getAge());
			super.pstmt.setString(5, user.getAddr());
			System.out.println(user.getAddr());
			super.pstmt.setString(6, user.getTel());
			super.pstmt.setInt(7, user.getId());
			num = pstmt.executeUpdate();
			System.out.println(pstmt.executeUpdate());
			System.out.println(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();System.out.println(num);
		return num;
	}

	@Override
	public User find(int id) {
		User user = null;
		try {
			super.regist();
			super.connection();
			String sql = "select * from User where id=?";
			super.getPst(sql);
			super.pstmt.setInt(1, id);
			super.rs = pstmt.executeQuery();
			while (rs.next()) {
				user = createUser(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return user;
	}

	@Override
	public List<User> findList() {
		List<User> list = new ArrayList<>();
		try {
			super.regist();
			super.connection();
			String sql = "select * from User where id<>1";
			super.getPst(sql);
			super.rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = createUser(rs);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return list;
	}

	@Override
	public int delete(int id) {
		int num = 0;
		try {
			super.regist();
			super.connection();
			String sql = "DELETE FROM USER WHERE id=?";
			super.getPst(sql);
			super.pstmt.setInt(1, id);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return num;
	}

	private User createUser(ResultSet rs) throws SQLException {
		User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
				rs.getString(6), rs.getString(7),rs.getInt(8),rs.getInt(9), rs.getString(10));

		return user;
	}

	@Override
	public int updateMoney(int id, int money) {
		int num = 0;
		try {
			super.regist();
			super.connection();
			String sql = "update USER set money=? WHERE id=?";
			super.getPst(sql);
			super.pstmt.setInt(1, money);
			super.pstmt.setInt(2, id);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return num;
	}

	@Override
	public int updateIntegral(int id, int integral) {
		int num = 0;
		try {
			super.regist();
			super.connection();
			String sql = "update USER set integral=? WHERE id=?";
			super.getPst(sql);
			super.pstmt.setInt(1, integral);
			super.pstmt.setInt(2, id);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return num;
	}

	@Override
	public int updateHeadimg(int id, String headimg) {
		int num = 0;
		try {
			super.regist();
			super.connection();
			String sql = "update USER set headimg=? WHERE id=?";
			super.getPst(sql);
			super.pstmt.setString(1, headimg);
			super.pstmt.setInt(2, id);
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return num;
	}

	@Override
	public User findByName(String name) {
		User user = null;
		try {
			super.regist();
			super.connection();
			String sql = "select * from User where `name`=?";
			super.getPst(sql);
			super.pstmt.setString(1, name);
			super.rs=pstmt.executeQuery();
			while (rs.next()) {
				user = createUser( rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.close();
		return user;
	}
}
