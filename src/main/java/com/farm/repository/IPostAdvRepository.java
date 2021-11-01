package com.farm.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.farm.entity.PostAdvertisement;


public interface IPostAdvRepository extends JpaRepository<PostAdvertisement,Integer>{

	@Transactional
    @Modifying
    @Query("update PostAdvertisement p set p.cropName=?1, p.requiredQuantity=?2 where p.cropId=?3")
    void updatePostById(String cropName, int requiredQuantity, int cropId);
}