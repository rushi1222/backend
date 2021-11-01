package com.farm.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.farm.entity.LoginDetails;
import com.farm.entity.Role;
import com.farm.entity.Supplier;

@Service
public interface ILoginDetailsService {

	public LoginDetails saveLoginDetails(LoginDetails logindetails);
	LoginDetails validateLoginDetails(String username, String pwd, Role role) throws Exception;
	
	public List<LoginDetails> getAllLoginDetails();
	
	public void updateLoginDetails(LoginDetails logindetails, long userid);
	public LoginDetails findLoginDetailsById(long userid);
	public void deleteLoginDetailsById(long userid);
	public LoginDetails getLoginDetailsById(long userid);
	public void updateLoginDetail(LoginDetails detail, long userid);
	
}
