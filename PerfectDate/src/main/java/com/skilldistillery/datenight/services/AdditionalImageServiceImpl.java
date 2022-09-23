package com.skilldistillery.datenight.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.datenight.entities.AdditionalImage;
import com.skilldistillery.datenight.repositories.AdditionalImageRepository;

@Service
public class AdditionalImageServiceImpl implements AdditionalImageService {

	@Autowired
	private AdditionalImageRepository additionalImgRepo;

	@Override
	public List<AdditionalImage> index() {
		return additionalImgRepo.findAll();
	}

	@Override
	public AdditionalImage additionalImageById(Integer id) {
		return additionalImgRepo.findAdditionalImageById(id);
	}

	@Override
	public AdditionalImage createAdditionalImage(AdditionalImage additionalImage) {
		return additionalImgRepo.saveAndFlush(additionalImage);
	}

	@Override
	public AdditionalImage updateAdditionalImage(AdditionalImage additionalImage) {
		AdditionalImage additionalImgToUpdate = additionalImgRepo.findAdditionalImageById(additionalImage.getId());
		if(additionalImgToUpdate != null) {
			additionalImgToUpdate.setImageUrl(additionalImage.getImageUrl());
			additionalImgToUpdate.setCaption(additionalImage.getCaption());
			additionalImgToUpdate.setReview(additionalImage.getReview());
			additionalImgRepo.saveAndFlush(additionalImgToUpdate);
			return(additionalImgToUpdate);
		}
		return additionalImgToUpdate;
	}

	@Override
	public boolean deleteAdditionalImage(Integer id) {
		boolean additionalImgDeleted = false;
		if(additionalImgRepo.existsById(id)) {
			additionalImgRepo.deleteById(id);
			additionalImgDeleted = true;
		}
		return additionalImgDeleted;
	}

	
	
	
	
}
