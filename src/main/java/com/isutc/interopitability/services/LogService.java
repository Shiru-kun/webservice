package com.isutc.interopitability.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isutc.interopitability.interfaces.LogRepository;
import com.isutc.interopitability.models.WebServiceHistory;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepo;

	public boolean save(WebServiceHistory log) {

		try {
			log.setDataEntry(LocalDateTime.now());
			logRepo.save(log);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

	public List<WebServiceHistory> findAll(WebServiceHistory log) {

		return logRepo.findAll();
	}

	public WebServiceHistory findById(long logId) {

		return logRepo.getOne(logId);
	}
}
