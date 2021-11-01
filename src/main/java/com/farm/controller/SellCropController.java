package com.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.entity.Farmer;
import com.farm.entity.FarmingTip;
import com.farm.entity.PostAdvertisement;
import com.farm.entity.SellCrop;
import com.farm.repository.ISellCropRepository;
import com.farm.services.IFarmerService;

@RestController
@RequestMapping("/farm")
@CrossOrigin
public class SellCropController {

	
	@Autowired
	ISellCropRepository sellcroprepo;
	
	@Autowired
	IFarmerService farmservice;
	
	@PostMapping(path = "/sellcrop/{farmerid}", consumes = { "application/json" })
    public ResponseEntity<String> saveSellCrop(@PathVariable("farmerid") long farmerid, @RequestBody SellCrop crop) 
    {
		 Farmer farmer = farmservice.getFarmerById(farmerid);
		 
		crop.setFarmer(farmer);
	    crop.setSoldby(farmer.getFarmername());
	    crop.setCropname(crop.getCropname());
	    crop.setQuantity(crop.getQuantity());
	    crop.setPrice(crop.getPrice());
	    
	    farmservice.sellCrop(crop);
	        
	        return new ResponseEntity<String>("Crop Sold Successfully!!!!", HttpStatus.OK);
    }
	

	
	// TO VIEW DETAILS OF CROPS SOLD BY FARMERS(WITH PRICE)
    @GetMapping(path ="/viewcropadvertisment", produces = { "application/json" })
    public ResponseEntity<List<SellCrop>> getAdvertisement() {
        List<SellCrop> viewpost = farmservice.getAllCrops();
        return new ResponseEntity<List<SellCrop>>(viewpost, HttpStatus.OK);
    }
}
