package com.skilldistillery.datenight.services;

import java.util.List;

import com.skilldistillery.datenight.entities.AdditionalImage;

public interface AdditionalImageService {

	List<AdditionalImage> index();

	AdditionalImage additionalImageById(Integer id);

	AdditionalImage createAdditionalImage(AdditionalImage additionalImage);

	AdditionalImage updateAdditionalImage(AdditionalImage additionalImage);

	boolean deleteAdditionalImage(Integer id);
}
