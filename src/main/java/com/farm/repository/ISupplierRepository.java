package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.farm.entity.Supplier;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier,Long> {

	@Transactional
	@Modifying
	@Query("update Supplier s set  s.suppliername=?1, s.supplieraddress=?2 , s.supmobileno=?3   where s.supplierid=?4")
	void updateSupplierById(String suppliername, String supplieraddress, long supmobileno,  long supplierid);
	

}
