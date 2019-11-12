package com.company.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.company.bean.Recording;
import com.company.dao.IRecordingDao;

/**
 * @author WT
 * @category 购买记录数据访问实现类
 */
public class RecordingDaoImpl extends BaseDao implements IRecordingDao {

	@Test
	public void test() {
//		 Recording recording = new Recording(3, 3, new Timestamp(new
//		 java.util.Date().getTime()));
//		 add(recording);
		deleteById(2);
	}

	@Override
	public List<Recording> findAll(int uid) {
		List<Recording> list = new ArrayList<>();
		try {
			regist();
			super.connection();
			String sql = "select * from recording where uid = ?";
			super.getPst(sql);
			super.pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Recording recording = new Recording(rs.getInt(2), rs.getInt(3), rs.getTimestamp(4));
				list.add(recording);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return list;
	}

	@Override
	public Recording find(int id) {
		Recording recording = null;
		try {
			regist();
			super.connection();
			String sql = "select * from recording where id = ?";
			super.getPst(sql);
			super.pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				recording = new Recording(rs.getInt(2), rs.getInt(3), rs.getTimestamp(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return recording;
	}

	@Override
	public int add(Recording recording) {
		int i = 0;
		try {
			super.connection();
			String sql = "insert into recording(uid,gid,datetime) values(?,?,?)";
			super.getPst(sql);
			super.pstmt.setInt(1, recording.getUid());
			super.pstmt.setInt(2, recording.getGid());
			super.pstmt.setTimestamp(3, recording.getDatetime());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return i;
	}

	@Override
	public int delete(int uid) {
		int i = 0;
		try {
			super.connection();
			String sql = "delete from recording where uid = ? ";
			super.getPst(sql);
			super.pstmt.setInt(1, uid);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			super.close();
		}
		return i;
	}

	@Override
	public int deleteById(int id) {
		int i = 0;
		try {
			super.connection();
			String sql = "delete from recording where id =? ";
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

}
