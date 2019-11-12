package com.company.service.impl;

import java.util.List;

import com.company.bean.Recording;
import com.company.dao.IRecordingDao;
import com.company.dao.impl.RecordingDaoImpl;
import com.company.service.IRecordingService;

public class RecordingServiceImpl implements IRecordingService {

	IRecordingDao recordingDao = new RecordingDaoImpl();

	@Override
	public List<Recording> findAll(int uid) {
		return recordingDao.findAll(uid);
	}

	@Override
	public Recording find(int id) {
		return recordingDao.find(id);
	}

	@Override
	public boolean add(Recording recording) {
		return recordingDao.add(recording) > 0 ? true : false;
	}

	@Override
	public boolean delete(int uid) {
		return recordingDao.delete(uid) > 0 ? true : false;
	}

	@Override
	public boolean deleteById(int id) {
		return recordingDao.deleteById(id) > 0 ? true : false;
	}

}
