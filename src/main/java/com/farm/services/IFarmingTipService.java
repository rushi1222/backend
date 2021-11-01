package com.farm.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.farm.entity.FarmingTip;

@Service
public interface IFarmingTipService 
{

	public List<FarmingTip> getAllFarmingTips();
    public FarmingTip saveFarmingTips(FarmingTip farmingtip);
    public void updateFarmingTip(FarmingTip farmingtip, int tipid);
    public FarmingTip findFarmingTipById(int tipid);
    public void deleteFarmingTipById(int tipid);
}
