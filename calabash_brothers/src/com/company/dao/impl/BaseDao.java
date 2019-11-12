package com.company.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 张游
 * @category 数据库连接基类
 */
public class BaseDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * @category 加载驱动
	 */
	protected void regist() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @category 创建连接
	 */
	protected void connection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://172.3.21.207:3306/inshop", "rjw", "111");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @category 创建预编译指令
	 * @param sql
	 */
	protected void getPst(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @category 关闭结果集、预编译指令、连接
	 */
	protected void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
