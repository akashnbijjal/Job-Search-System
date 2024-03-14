package com.job.jobbasket.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.job.jobbasket.model.Job_Basket;

public interface JobbasketRepository extends MongoRepository<Job_Basket, Long> {

	List<Job_Basket> findAllByUserId(long userId);

}
