package com.farm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.farm.entity.Farmer;
import com.farm.entity.Supplier;

@Repository
public interface IFarmerRepository extends JpaRepository<Farmer,Long> {

	@Transactional
	@Modifying
	@Query("update Farmer f set  f.farmername=?1, f.farmeraddress=?2 , f.farmmobileno=?3   where f.farmerid=?4")
	void updateFarmerById(String farmername, String farmeraddress, long farmmobileno,  long farmerid);
	
	

}
