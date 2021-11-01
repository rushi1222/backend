package com.farm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farm.entity.PostAdvertisement;
import com.farm.exception.AdvNotFoundException;
import com.farm.repository.IPostAdvRepository;

@Service
public class PostAdvService implements IPostAdvService {
		 
	@Autowired
	IPostAdvRepository postrepo;
	
	@Override
	public List<PostAdvertisement> getAllAdv()	{
		
		return postrepo.findAll();
	}
	
	@Override
	public PostAdvertisement saveAllAdv(PostAdvertisement postAdvertisement)	{
		//PostAdvertisement post1 = repo.save(postAdvertisement);
		return postrepo.save(postAdvertisement);
	}
	
	@Override
	public void updateAdv(PostAdvertisement postAdvertisement, int cropId) {
	
		// TODO Auto-generated method stub
		postrepo.updatePostById(postAdvertisement.getCropName(), postAdvertisement.getRequiredQuantity(), postAdvertisement.getCropId());
	}
	@Override
	public void deleteAdvById(int cropId) {
	postrepo.deleteById(cropId);
 	}

	
	@Override
	public PostAdvertisement findAdvById(int cropId){
		Optional<PostAdvertisement> postAdvertisement = postrepo.findById(cropId);
		if (postAdvertisement.isEmpty() || postAdvertisement == null)
			{
			throw new AdvNotFoundException("Unable to locate ID: " +cropId);
		}
		return postAdvertisement.get();
}
}
