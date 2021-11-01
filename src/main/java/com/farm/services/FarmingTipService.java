package com.farm.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.entity.Farmer;
import com.farm.entity.FarmingTip;
import com.farm.exception.FarmerNotFoundException;
import com.farm.exception.TipNotFoundException;
import com.farm.repository.IFarmingTipRepository;

@Service
public class FarmingTipService implements IFarmingTipService {

	 @Autowired        
	 IFarmingTipRepository tiprepo;
	 
	 @Override        
	 public List<FarmingTip> getAllFarmingTips() {
         // TODO Auto-generated method stub            
		 return tiprepo.findAll();
     }
	
	 @Override        
	 public FarmingTip saveFarmingTips(FarmingTip farmingtip) {
         // TODO Auto-generated method stub            
		 FarmingTip newFarmingTips = tiprepo.save(farmingtip);
         return newFarmingTips;
     }
	 
	 @Override        
	 public void updateFarmingTip(FarmingTip farmingtip, int tipid) {
         // TODO Auto-generated method stub            
		 tiprepo.updateFarmingTipById(farmingtip.getFertilizers(),farmingtip.getCrop(),farmingtip.getSeason(), tipid);
     }
	 
	 @Override        
	 public void deleteFarmingTipById(int tipid) {
         // TODO Auto-generated method stub            
		 tiprepo.deleteById(tipid);
     }
	 
	 @Override        
	 public FarmingTip findFarmingTipById(int tipid) {
         // TODO Auto-generated method stub            
		 Optional<FarmingTip> farmingtip = tiprepo.findById(tipid);

			if (farmingtip.isEmpty() || farmingtip == null) {
				throw new TipNotFoundException("Tip Not Found For The Given Tip ID : " + tipid);
			}
			return farmingtip.get();
     }
}
