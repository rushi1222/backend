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

import com.farm.entity.PostAdvertisement;
import com.farm.entity.Supplier;
import com.farm.services.IPostAdvService;
import com.farm.services.ISupplierService;

@RestController
@RequestMapping("/farm")
@CrossOrigin
public class PostAdvController {
 
    List<PostAdvertisement> complaints = new ArrayList<PostAdvertisement>();

    @Autowired
    IPostAdvService postAdvService;
    
    @Autowired
    ISupplierService supservice;

    

    // TO ADD AN ADVERTISEMENT
        @PostMapping(path ="/addAdv/{supplierid}", consumes = { "application/json" })
        public ResponseEntity<PostAdvertisement> saveAdvertisement(@PathVariable("supplierid") long supplierid, @RequestBody PostAdvertisement postAdvertisement) 
        {
        	 Supplier supplier = supservice.getSupplierById(supplierid);
    		 
        	 postAdvertisement.setSupplier(supplier);
        	 postAdvertisement.setPostedby(supplier.getSuppliername());
        	 postAdvertisement.setContactno(supplier.getSupmobileno());
        	 postAdvertisement.setCropName(postAdvertisement.getCropName());
        	 postAdvertisement.setRequiredQuantity(postAdvertisement.getRequiredQuantity());
        	 
     	    
        	 
     	        
        	PostAdvertisement addpost = postAdvService.saveAllAdv(postAdvertisement);
 
            return new ResponseEntity<PostAdvertisement>(addpost, HttpStatus.OK);
 
        }
         
        
     // TO UPDATE AN ADVERTISEMENT   
        @PutMapping(path = "/updateAdv/{cropId}", consumes = { "application/json" })
        public ResponseEntity<List<PostAdvertisement>> updateComplaint(@PathVariable("cropId") int cropId, @RequestBody PostAdvertisement postAdvertisement)
        {
        	postAdvService.updateAdv(postAdvertisement, cropId);
            List<PostAdvertisement> advList = postAdvService.getAllAdv();
            return new ResponseEntity<List<PostAdvertisement>>(advList, HttpStatus.OK);
        }  
        
     // TO DELETE A COMPLAINT    
        @DeleteMapping("/deleteAdv/{cropId}")
        public ResponseEntity<List<PostAdvertisement>> deleteAdvById(@PathVariable("cropId") int cropId) {
        	PostAdvertisement postAdvertisements = postAdvService.findAdvById(cropId);
        	//Complaint complaints = complaintService.findComplaintById(id);

            if (postAdvertisements == null) {
                return new ResponseEntity<List<PostAdvertisement>>(HttpStatus.NOT_FOUND);
            } else {
            	postAdvService.deleteAdvById(cropId);
            }
            List<PostAdvertisement> AdvList = postAdvService.getAllAdv();
            return new ResponseEntity<List<PostAdvertisement>>(AdvList, HttpStatus.OK);
        }
       
//        // TO ADD A ADVERTISEMENT
//        @PostMapping(path ="/addAdv", consumes = { "application/json" })
//        public ResponseEntity<PostAdvertisement> saveAdvertisement(@RequestBody PostAdvertisement postAdvertisement) 
//        {
// 
//        	PostAdvertisement addpost = postAdvService.saveAllAdv(postAdvertisement);
// 
//            return new ResponseEntity<PostAdvertisement>(addpost, HttpStatus.OK);
// 
//        }
      

}