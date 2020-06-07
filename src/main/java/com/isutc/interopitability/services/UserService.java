package com.isutc.interopitability.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isutc.interopitability.interfaces.IUser;
import com.isutc.interopitability.models.User;

@Service
public class UserService {

	
	@Autowired
	private IUser iUser;
	
	
	public boolean save(User user) {
		
		try {
			iUser.save(user);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		
	}
	
public boolean update(User user) {
		
		try {
			iUser.save(user);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		
	}
public boolean delete(User user) {
	
	try {
		iUser.delete(user);
		return true;
	} catch (Exception e) {
		return false;
		// TODO: handle exception
	}
	
}

public User findById(long userId) {
	return iUser.getOne(userId);
	
	
	
}
public List<User> findAll() {
	return iUser.findAll();
	
	
	
}
public User findUserByBi(String bi) {
	return iUser.findByBi(bi);
	
	
	
}

public User findStudentByInstitutionIdAndBi(long institutionId, String bi) {
	return iUser.findStudentByInstitutionAndId(institutionId, bi);
	
	
	
}
}
