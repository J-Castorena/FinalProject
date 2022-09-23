package com.skilldistillery.datenight.services;

import java.util.List;

public interface AdditionalImage {

	List<AdditionalImage> index();

	AdditionalImage additionalImageById(Integer id);

	AdditionalImage createAdditionalImage(AdditionalImage additionalImage);

	AdditionalImage updateAdditionalImage(AdditionalImage additionalImage);

	boolean deleteAdditionalImage(Integer id);
}
