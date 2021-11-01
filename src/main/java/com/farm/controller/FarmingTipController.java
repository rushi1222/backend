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
import com.farm.services.IFarmingTipService;

@RestController
@RequestMapping("/farm")
@CrossOrigin
public class FarmingTipController {

	List<FarmingTip> farmingtips = new ArrayList<FarmingTip>();
	
	
	@Autowired    
	IFarmingTipService farmingtipService;
    
	
	
// TO ADD A FARMING TIP
	@PostMapping(path = "/farmingtips", consumes = { "application/json" })
	public ResponseEntity<FarmingTip> saveFarmers(@RequestBody FarmingTip farmingtip) {

		FarmingTip newFarmingTip = farmingtipService.saveFarmingTips(farmingtip);

		return new ResponseEntity<FarmingTip>(newFarmingTip, HttpStatus.OK);

	}
	
// TO UPDATE A FARMING TIP	
	@PutMapping(path = "/farmingtips/update/{tipid}", consumes = { "application/json" })
	public ResponseEntity<List<FarmingTip>> updateFarmingTip(@PathVariable("tipid") int tipid, @RequestBody FarmingTip farmingtips)
	{
		farmingtipService.updateFarmingTip(farmingtips, tipid);
		List<FarmingTip> farmingtipList = farmingtipService.getAllFarmingTips();

		return new ResponseEntity<List<FarmingTip>>(farmingtipList, HttpStatus.OK);
	}

	// TO REMOVE A TIP	
	@DeleteMapping("/farmingtips/delete/{tipid}")
	public ResponseEntity<List<FarmingTip>> deleteFarmingTipById(@PathVariable("tipid") int tipid) {
		FarmingTip farmingtips = farmingtipService.findFarmingTipById(tipid);

		if (farmingtips == null) {
			return new ResponseEntity<List<FarmingTip>>(HttpStatus.NOT_FOUND);
		} else {
			farmingtipService.deleteFarmingTipById(tipid);
		}
		List<FarmingTip> farmingtipsList = farmingtipService.getAllFarmingTips();
		return new ResponseEntity<List<FarmingTip>>(farmingtipsList, HttpStatus.OK);
	}
}
