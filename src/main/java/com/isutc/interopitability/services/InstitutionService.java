package com.isutc.interopitability.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isutc.interopitability.interfaces.InstitutionRepository;
import com.isutc.interopitability.models.Institution;

@Service
public class InstitutionService {

	@Autowired
	private InstitutionRepository insRepo;

	public boolean save(Institution institution) {

		try {
			institution.setDateEntry(LocalDateTime.now());
			insRepo.save(institution);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean update(Institution institution) {

		try {
			insRepo.save(institution);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean detele(Institution institution) {

		try {
			insRepo.delete(institution);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public List<Institution> findAll() {

		return insRepo.findAll();

	}

	public Institution findById(Long insId) {

		return insRepo.getOne(insId);

	}

}
