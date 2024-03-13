package com.job.jobs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.jobs.model.Jobs;
import com.job.jobs.service.JobServiceImpl;


@RestController
@RequestMapping("jobs")
public class JobController {

	@Autowired
	private JobServiceImpl service;

	@PostMapping("/addJobs")
	public ResponseEntity<Jobs> addJobs(@RequestBody Jobs newJobs) {
		Jobs jobs = service.addJobs(newJobs);
		return new ResponseEntity<Jobs>(jobs, HttpStatus.CREATED);
	}

	@GetMapping("/viewJobs/{jobId}")
	public ResponseEntity<Jobs> viewJobs(@PathVariable long jobId) {
		Jobs jobs = service.viewJobs(jobId);
		return new ResponseEntity<Jobs>(jobs, HttpStatus.ACCEPTED);
	}

	@GetMapping("/searchByLocation/{location}")
	public ResponseEntity<List<Jobs>> searchByLocation(@PathVariable String location) {
		List<Jobs> jobs = service.searchByLocation(location);
		return new ResponseEntity<List<Jobs>>(jobs, HttpStatus.ACCEPTED);
	}

	@GetMapping("/searchByJobTitle/{jobTitle}")
	public ResponseEntity<List<Jobs>> searchByJobTitle(@PathVariable String jobTitle) {
		List<Jobs> jobs = service.searchByJobtitle(jobTitle);
		return new ResponseEntity<List<Jobs>>(jobs, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteJob/{jobId}")
	public ResponseEntity<Jobs> deleteJob(@PathVariable long jobId) {
		Jobs job = service.deleteJob(jobId);
		return new ResponseEntity<Jobs>(job, HttpStatus.ACCEPTED);
	}

}
