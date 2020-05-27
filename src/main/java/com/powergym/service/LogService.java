package com.powergym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powergym.model.Log;
import com.powergym.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;
	
	public void saveLog(Log log) {
		logRepository.save(log);
	}
	
	public List<Log> findAllLogs() {
		return logRepository.findAll();
	}
	
	
}
