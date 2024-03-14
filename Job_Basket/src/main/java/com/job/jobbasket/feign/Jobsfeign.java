package com.job.jobbasket.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.job.jobbasket.model.Jobs;

@FeignClient(name = "Jobs", url = "http://localhost:8082/jobs/")
public interface Jobsfeign {

	@GetMapping("/viewJobs/{jobId}")
	public ResponseEntity<Jobs> viewJobs(@PathVariable long jobId);
}
