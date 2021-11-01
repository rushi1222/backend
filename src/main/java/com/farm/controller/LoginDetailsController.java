package com.farm.controller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farm.entity.Complaint;
import com.farm.entity.Farmer;
import com.farm.entity.LoginDetails;
import com.farm.entity.Registration;
import com.farm.entity.Role;
import com.farm.entity.Supplier;
import com.farm.services.IFarmerService;
import com.farm.services.ILoginDetailsService;
import com.farm.services.ISupplierService;

@RestController
@RequestMapping("/farm")
@CrossOrigin
public class LoginDetailsController {

	 @Autowired    
	 ILoginDetailsService loginDetailsService;
	 
	 @Autowired
	 ISupplierService supplierService;
		
     @Autowired 
	 IFarmerService farmerService; 
		

		// FOR LOGIN    
		
		    @PostMapping(path = "/login")
		    public ResponseEntity<Long> loginCheck(@RequestBody LoginDetails ld) {
		        LoginDetails userLogin = new LoginDetails();
		        
		    
				try {
					userLogin = loginDetailsService.validateLoginDetails(ld.getUsername(),ld.getPwd(),ld.getRole());
					 
					
					if (userLogin != null) {
				    
				        } 
				} catch (Exception e) {
					
				}
		       
				 return new ResponseEntity<Long>(userLogin.getUserid(), HttpStatus.OK);
		    }
     
     
		    
		    
		    // ADD ADMIN DETAILS
		    
		    @PostMapping(path = "/addAdmin", consumes = { "application/json" })
		    public ResponseEntity<?> saveLoginDetails(@RequestBody LoginDetails logindetails) throws Exception {
		    	
		    	if(!Role.ADMIN.equals(logindetails.getRole())) {
		    		String msg="You are not Allowed to enter as an Admin!!";
		    		return new ResponseEntity<String>(msg, HttpStatus.OK);
		    	//	throw new Exception("You are not Allowed to enter as an Admin!!");
		    		
		    	}
		    	
		    	LoginDetails newLoginDetails = loginDetailsService.saveLoginDetails(logindetails);
		         return new ResponseEntity<LoginDetails>(newLoginDetails, HttpStatus.OK);
	}
		    
		 // TO ADD A NEW SUPPLIER/FARMER
		    
			@PostMapping(path = "/register", consumes = { "application/json" })
			public ResponseEntity<?> saveSuppliers(@RequestBody Registration registration ) {
             LoginDetails loginDetails =loginDetailsService.saveLoginDetails(registration.getLoginDetails());
				long id=loginDetails.getUserid();
				
             if(Role.SUPPLIER.equals(registration.getLoginDetails().getRole()))
            		 {
            	 
            Supplier newSupplier= new Supplier();
            registration.getSupplier().setSupplierid(id);
            newSupplier= supplierService.saveSuppliers(registration.getSupplier());
            
             return new ResponseEntity<Supplier>(newSupplier, HttpStatus.OK);
            		 }
             else
             {
            	 Farmer newFarmer= new Farmer();
            	 registration.getFarmer().setFarmerid(id);
            	 newFarmer=farmerService.saveFarmers(registration.getFarmer());
            	 return new ResponseEntity<Farmer>(newFarmer, HttpStatus.OK);
             }
				

			}
			
			
			
			// TO UPDATE LOGIN DETAILS	
			@PutMapping(path = "/logindetails/update/{userid}", consumes = { "application/json" })
			public ResponseEntity<List<LoginDetails>> updateLoginDetails(@PathVariable("userid") long userid, @RequestBody LoginDetails details)
			{
				loginDetailsService.updateLoginDetails(details, userid);
				List<LoginDetails> loginDetailsList = loginDetailsService.getAllLoginDetails();

				return new ResponseEntity<List<LoginDetails>>(loginDetailsList, HttpStatus.OK);
			}
			
			// TO UPDATE A LOGIN DETAIL OF USER WHO HAS LOGGED IN
			@PutMapping(path = "/logindetail/update/{userid}", consumes = { "application/json" })
			public ResponseEntity<LoginDetails> updateLoginDetail(@PathVariable("userid") long userid, @RequestBody LoginDetails detail) {
	
				loginDetailsService.updateLoginDetail(detail, userid);
				LoginDetails det = loginDetailsService.getLoginDetailsById(userid);

			 return new ResponseEntity<LoginDetails>(det, HttpStatus.OK);
			}
			
			// TO REMOVE LOGIN DETAILS	
						@DeleteMapping("/logindetails/delete/{userid}")
						public ResponseEntity<List<LoginDetails>> deleteLoginDetailsById(@PathVariable("userid") long userid) {
							LoginDetails loginDetails = loginDetailsService.findLoginDetailsById(userid);

							if (loginDetails == null) {
								return new ResponseEntity<List<LoginDetails>>(HttpStatus.NOT_FOUND);
							} else {
								loginDetailsService.deleteLoginDetailsById(userid);
								
								
							}
							List<LoginDetails> loginDetailsList = loginDetailsService.getAllLoginDetails();
							return new ResponseEntity<List<LoginDetails>>(loginDetailsList, HttpStatus.OK);
						}
						
			// TO VIEW ALL LOGIN DETAILS
						@GetMapping(path = "/getlogindetails", produces = { "application/json" })
						public ResponseEntity<List<LoginDetails>> getLoginDetails() {
							List<LoginDetails> loginDetailsList = loginDetailsService.getAllLoginDetails();
							return new ResponseEntity<List<LoginDetails>>(loginDetailsList, HttpStatus.OK);
						}
						
						
						// TO VIEW SINGLE LOGIN DETAIL
						@GetMapping(path = "/getlogindetail/{userid}", produces = { "application/json" })
						public ResponseEntity<LoginDetails> getDetailsById(@PathVariable("userid") long userid, @RequestBody LoginDetails detail) {
							LoginDetails loginDetail = loginDetailsService.getLoginDetailsById(userid);
							return new ResponseEntity<LoginDetails>(loginDetail, HttpStatus.OK);
						}
						
						
						// TO UPDATE FARMERS	
						@PutMapping(path = "/farmers/update/{farmerid}", consumes = { "application/json" })
						public ResponseEntity<List<Farmer>> updateFarmers(@PathVariable("farmerid") long farmerid, @RequestBody Farmer farmers)
						{
							farmerService.updateFarmers(farmers, farmerid);
							List<Farmer> farmerList = farmerService.getAllFarmers();

							return new ResponseEntity<List<Farmer>>(farmerList, HttpStatus.OK);
						}
						
						// TO UPDATE SUPPLIERS	
						@PutMapping(path = "/suppliers/update/{supplierid}", consumes = { "application/json" })
						public ResponseEntity<List<Supplier>> updateSuppliers(@PathVariable("supplierid") long supplierid, @RequestBody Supplier suppliers)
						{
							supplierService.updateSuppliers(suppliers, supplierid);
							List<Supplier> supplierList = supplierService.getAllSuppliers();

							return new ResponseEntity<List<Supplier>>(supplierList, HttpStatus.OK);
						}
}
