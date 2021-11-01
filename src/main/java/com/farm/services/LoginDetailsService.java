package com.farm.services;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farm.entity.LoginDetails;
import com.farm.entity.Role;
import com.farm.entity.Supplier;
import com.farm.exception.SupplierNotFoundException;
import com.farm.exception.UserNotFoundException;
import com.farm.repository.ILoginDetailsRepository;

@Service
public class LoginDetailsService implements ILoginDetailsService {

	
	
	@Autowired
	ILoginDetailsRepository loginDetailsRepository;
	


	    @Override
		public LoginDetails saveLoginDetails(LoginDetails logindetails) {
			// TODO Auto-generated method stub
			return loginDetailsRepository.save(logindetails);
		}
		
		
		@Override    
		 public LoginDetails validateLoginDetails(String username, String pwd, Role role) throws Exception {
		              
			 List<LoginDetails> users = loginDetailsRepository.findAll();
			
			 if (null==users) {
				 throw new Exception("User Does Not Exists!!");
	                
	            }
			 LoginDetails checkUser = null;
		        for (LoginDetails user : users) {
		        	
		            if (user.getUsername().equals(username) && user.getPwd().equals(pwd)) {
		               checkUser=user;
		            }
		            
		            
		        }
		        if(null!=checkUser && null!=role && role.equals(checkUser.getRole()))
		        {
		        	return checkUser;
		        }
		        else
	            {
	            	throw new Exception("Incorrect UserName or Password!!");
	            }
		       
		    }
		
		
		
		@Override 
		public List<LoginDetails> getAllLoginDetails() {
			// TODO Auto-generated method stub
			return loginDetailsRepository.findAll();
		}
		
		
		@Override 
		public LoginDetails findLoginDetailsById(long userid) {
			// TODO Auto-generated method stub
			Optional<LoginDetails> user = loginDetailsRepository.findById(userid);

			if (user.isEmpty() || user == null) {
				throw new UserNotFoundException("User Not Found For The Given User ID : " + userid);
			}
			return user.get();

		}
		
		@Override 
		public void deleteLoginDetailsById(long userid) {
			// TODO Auto-generated method stub
			loginDetailsRepository.deleteById(userid);
		}
		

			@Override    
		    public LoginDetails getLoginDetailsById(long userid) {
		        // TODO Auto-generated method stub        
		    	return loginDetailsRepository.findById(userid).get();
		    }
		    
		    
		    @Override
		    public void updateLoginDetails(LoginDetails user, long userid) {
		    // TODO Auto-generated method stub
		    	loginDetailsRepository.updateLoginDetailsById(user.getUsername(), user.getPwd(), user.getRole(), userid);
		    }


			@Override
			public void updateLoginDetail(LoginDetails detail, long userid) {
				// TODO Auto-generated method stub
				loginDetailsRepository.updateLoginDetailById(detail.getUsername(), detail.getPwd(), userid);
			}

		
}
