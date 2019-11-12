package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.company.bean.Area;
import com.company.dao.IAreaDao;

/**
 * @author hzm
 * @category 区县的数据访问实现类
 */
public class AreaDaoImpl extends BaseDao implements IAreaDao {

	public List<Area> findAreasByCid(String cityId) {
		List<Area> list = new ArrayList<Area>();
		try {
			connection();
			String sql = "select * from area where cityId = ?";
			getPst(sql);
			pstmt.setString(1, cityId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Area area = new Area(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

	@Test
	public void test(){
		System.out.println(findObject("110101").getArea());
	}
	
	public Area findObject(String areaId) {
		Area area = null;
		try {
			connection();
			String sql = "select * from area where areaID = ?";
			getPst(sql);
			pstmt.setString(1, areaId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				area = new Area(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return area;
	}

}
