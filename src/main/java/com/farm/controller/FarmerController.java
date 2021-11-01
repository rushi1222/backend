package com.farm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.entity.Farmer;
import com.farm.entity.FarmingTip;
import com.farm.entity.LoginDetails;
import com.farm.entity.PostAdvertisement;
import com.farm.entity.Supplier;
import com.farm.exception.FarmerNotFoundException;
import com.farm.exception.SupplierNotFoundException;
import com.farm.services.IFarmerService;
import com.farm.services.IFarmingTipService;
import com.farm.services.ILoginDetailsService;
import com.farm.services.IPostAdvService;


@RestController
@RequestMapping("/farm")
@CrossOrigin
public class FarmerController {
		
			List<Farmer> farmers = new ArrayList<Farmer>();
			
			@Autowired
			IFarmerService farmerService;
			
			@Autowired
			IPostAdvService postadvservice;
			
			@Autowired
			IFarmingTipService farmingTipService; 
			
			@Autowired
			ILoginDetailsService logdetailService;
			
			// TO VIEW ALL FARMERS 
			
				@GetMapping(path = "/farmers", produces = { "application/json" })
				public ResponseEntity<List<Farmer>> getFarmers() {
					List<Farmer> farmerList = farmerService.getAllFarmers();
					return new ResponseEntity<List<Farmer>>(farmerList, HttpStatus.OK);
				}
				
		
			// TO REMOVE A FARMER
				
				@DeleteMapping("/farmers/delete/{farmerid}")
				public ResponseEntity<List<Farmer>> deleteFarmerById(@PathVariable("farmerid") long farmerid) {
					Farmer farmers = farmerService.findFarmerById(farmerid);
               
					if (farmers == null) {
						return new ResponseEntity<List<Farmer>>(HttpStatus.NOT_FOUND);
					} else {
						farmerService.deleteFarmerById(farmerid);
						 System.out.println("Delete working!!");
						logdetailService.deleteLoginDetailsById(farmerid);
					}
					List<Farmer> farmersList = farmerService.getAllFarmers();
					return new ResponseEntity<List<Farmer>>(farmersList, HttpStatus.OK);
				}
				
				
			    
			 // TO VIEW ALL ADVERTISEMENTS 
		        @GetMapping(path ="/viewadv", produces = { "application/json" })
		        public ResponseEntity<List<PostAdvertisement>> getAdvertisement() {
		            List<PostAdvertisement> viewpost = postadvservice.getAllAdv();
		            return new ResponseEntity<List<PostAdvertisement>>(viewpost, HttpStatus.OK);
		        }

		        
		     // TO VIEW ALL FARMING TIPS
		    	@GetMapping(path = "/farmingtips", produces = { "application/json" })
		    	public ResponseEntity<List<FarmingTip>> getFarmingTips() {
		    		List<FarmingTip> farmingtipList = farmingTipService.getAllFarmingTips();
		    		return new ResponseEntity<List<FarmingTip>>(farmingtipList, HttpStatus.OK);
		    	}
		    	
		    	
		    	// TO GET FARMER DETAILS WHO LOGGED IN
				@GetMapping(path = "/getfarmer/{farmerid}", produces = { "application/json" })
				public ResponseEntity<Farmer> getFarmer(@PathVariable("farmerid")long farmerid) {
					Farmer farmer = farmerService.getFarmerById(farmerid);
				System.out.println("fetching user details....");
				return new ResponseEntity<Farmer>(farmer, HttpStatus.OK);
				}
				
				// TO UPDATE A FARMER DETAILS WHO LOGGED IN
				@PutMapping(path = "/farmer/update/{farmerid}", consumes = { "application/json" })
				public ResponseEntity<Farmer> updateFarmer(@PathVariable("farmerid") long farmerid, @RequestBody Farmer farmer) {
		
					farmerService.updateFarmer(farmer, farmerid);
					Farmer farm = farmerService.getFarmerById(farmerid);

				 return new ResponseEntity<Farmer>(farm, HttpStatus.OK);
				}
}
