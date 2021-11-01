package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.farm.entity.Complaint;

@Repository
public interface IComplaintRepository extends JpaRepository<Complaint,Integer>
{
	@Transactional
	@Modifying
	@Query("update Complaint c set c.complaint=?1  where c.complaintid=?2")
	void updateComplaintById(String complaint, int complaintid);
}
