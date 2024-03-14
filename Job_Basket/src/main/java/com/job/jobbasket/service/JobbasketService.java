package com.job.jobbasket.service;

import java.util.List;

import com.job.jobbasket.model.Job_Basket;

public interface JobbasketService {

	Job_Basket addtobasket(Job_Basket addBasket);

	List<Job_Basket> viewbasket(long userId);

	String removebasket(long jobbasketId);
	
	

}
