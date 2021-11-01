package com.farm.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.entity.Farmer;
import com.farm.entity.SellCrop;
import com.farm.exception.FarmerNotFoundException;
import com.farm.repository.IFarmerRepository;
import com.farm.repository.ISellCropRepository;


@Service
public class FarmerService implements IFarmerService {

	@Autowired
	IFarmerRepository farmrepo;
	
	@Autowired
    ISellCropRepository sellcroprepo;
	
	@Override 
	public List<Farmer> getAllFarmers() {
		// TODO Auto-generated method stub
		return farmrepo.findAll();
	}

	@Override 
	public Farmer saveFarmers(Farmer farmer) {
		// TODO Auto-generated method stub
		Farmer newFarmers = farmrepo.save(farmer);
		return newFarmers;
	}
	
	@Override 
	public void updateFarmer(Farmer farmer, long farmerid) {
		// TODO Auto-generated method stub
		farmrepo.updateFarmerById( farmer.getFarmername(), farmer.getFarmeraddress(), farmer.getFarmmobileno(), farmerid);
	}

	@Override 
	public Farmer findFarmerById(long farmerid) {
		// TODO Auto-generated method stub
		Optional<Farmer> farmer = farmrepo.findById(farmerid);

		if (farmer.isEmpty() || farmer == null) {
			throw new FarmerNotFoundException("Farmer Not Found For The Given Farmer ID : " + farmerid);
		}
		return farmer.get();

	}
	
	@Override 
	public void deleteFarmerById(long farmerid) {
		// TODO Auto-generated method stub
		farmrepo.deleteById(farmerid);
	}
	
		 
		    
		    
		    @Override    
		    public Farmer getFarmerById(long farmerid) {
		        // TODO Auto-generated method stub        
		    	return farmrepo.findById(farmerid).get();
		    }
		    
		    
		    // METHODS FOR SELL CROP
		    
		    @Override
		    public SellCrop sellCrop(SellCrop crop) {
		    	return sellcroprepo.save(crop);
		    }
		    
		    @Override
		    public List<SellCrop> getAllCrops() {
		        // TODO Auto-generated method stub
		    	return sellcroprepo.findAll();
		    }

		    @Override
		    public SellCrop getCropById(int sellcropid) {
		        // TODO Auto-generated method stub
		        return sellcroprepo.getById(sellcropid);
		    }

			@Override
			public void updateFarmers(Farmer farmers, long farmerid) {
				// TODO Auto-generated method stub
				farmrepo.updateFarmerById( farmers.getFarmername(), farmers.getFarmeraddress(), farmers.getFarmmobileno(), farmerid);
			}
		    
		  
		    
}
