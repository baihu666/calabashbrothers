package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Province;
import com.company.dao.IProvinceDao;

/**
 * @author hzm
 * @category 省份数据访问实现类
 * 
 *
 */
public class ProvinceDaoImpl extends BaseDao implements IProvinceDao {
	@Test
	public void test(){
		System.out.println(findAll().size());
	}
	public List<Province> findAll() {
		List<Province> list = new ArrayList<Province>();
		try {
			super.connection();
			String sql = "select * from Province";
			super.getPst(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Province pro = new Province();
				pro.setId(rs.getInt(1));
				pro.setProvinceId(rs.getString(2));
				pro.setProvince(rs.getString(3));
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

	public Province findObject(String provinceId) {
		Province province = null;
		try {
			super.connection();
			String sql = "select * from Province where provinceId = ?";
			super.getPst(sql);
			super.pstmt.setString(1, provinceId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				province = new Province(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return province;
	}

}
