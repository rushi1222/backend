package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.farm.entity.LoginDetails;
import com.farm.entity.Role;

@Repository
public interface ILoginDetailsRepository extends JpaRepository<LoginDetails,Long> {

	LoginDetails save(LoginDetails logindetails);

	@Transactional
	@Modifying
	@Query("update LoginDetails ld set  ld.username=?1, ld.pwd=?2, ld.role=?3    where ld.userid=?4")
	void updateLoginDetailsById(String username, String pwd, Role role,  long userid);
	
	@Transactional
	@Modifying
	@Query("update LoginDetails log set  log.username=?1, log.pwd=?2    where log.userid=?3")
	void updateLoginDetailById(String username, String pwd,  long userid);
}
