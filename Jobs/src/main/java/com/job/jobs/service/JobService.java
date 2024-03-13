package com.job.jobs.service;

import java.util.List;

import com.job.jobs.model.Jobs;

public interface JobService {

	Jobs addJobs(Jobs jobs);

	Jobs viewJobs(long jobId);

	List<Jobs> searchByLocation(String location);

	Jobs deleteJob(long jobId);

	List<Jobs> searchByJobtitle(String jobTitle);
}
