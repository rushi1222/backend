package com.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farm.entity.SellCrop;

@Repository
public interface ISellCropRepository extends JpaRepository<SellCrop, Integer> {

}
