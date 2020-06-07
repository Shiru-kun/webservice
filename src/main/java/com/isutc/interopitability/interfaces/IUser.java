package com.isutc.interopitability.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.isutc.interopitability.models.User;

public interface IUser extends JpaRepository<User, Long>{

	User findByBi(String bi);

	@Query(value="select * from user where institution_id=:institutionId and bi=:bi", nativeQuery=true)
	User findStudentByInstitutionAndId(@Param("institutionId") long institutionId, @Param("bi") String bi);

	
}
