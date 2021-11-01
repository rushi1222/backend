package com.farm.services;
import java.util.List;

import org.springframework.stereotype.Service;
import com.farm.entity.Farmer;
import com.farm.entity.SellCrop;
import com.farm.entity.Supplier;

@Service
public interface IFarmerService {

	public List<Farmer> getAllFarmers();
	public Farmer saveFarmers(Farmer farmer);
	public void updateFarmer(Farmer farmer, long farmerid);
	public Farmer findFarmerById(long farmerid);
	public void deleteFarmerById(long farmerid);
	public void updateFarmers(Farmer farmers, long farmerid);

		
		 public Farmer getFarmerById(long farmerid);
		 
    //SELL CROP
		    public SellCrop sellCrop(SellCrop crop);
		    public List<SellCrop> getAllCrops();
		    public SellCrop getCropById(int sellcropid);
		
		    
    
		    
}
