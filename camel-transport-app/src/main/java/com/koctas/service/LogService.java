package com.koctas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koctas.dto.Log;
import com.koctas.respository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;

	public List<Log> getAllLogs() throws Exception {
		List<Log> allLogs = null;
		try {
			allLogs = logRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return allLogs;
	}

	public void deleteLogById(String id) throws Exception {
		try {
			logRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
