package com.job.jobs.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.job.jobs.model.Jobs;

public interface JobRepository extends MongoRepository<Jobs, Long> {

	List<Jobs> findByLocation(String location);

	List<Jobs> findByJobTitle(String jobTitle);

}
