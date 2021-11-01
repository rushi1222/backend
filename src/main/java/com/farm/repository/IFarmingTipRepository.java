package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.farm.entity.FarmingTip;

@Repository
public interface IFarmingTipRepository extends JpaRepository<FarmingTip,Integer> {

	@Transactional    
	@Modifying    
	@Query("update FarmingTip ft set ft.fertilizers=?1, ft.crop=?2, ft.season=?3  where ft.tipid=?4")
    void updateFarmingTipById(String fertilizers, String crop, String season, int tipid);


}
