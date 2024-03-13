package com.job.jobs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.job.jobs.exception.JobNotFoundException;
import com.job.jobs.model.Jobs;
import com.job.jobs.repository.JobRepository;


@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	private static final Logger logger = LogManager.getLogger(JobServiceImpl.class);

    @Override
    public Jobs addJobs(Jobs jobs) {
        logger.info("Adding new job: {}", jobs);
        jobs.setJobId(sequenceGeneratorService.generateSequence(Jobs.SEQUENCE_NAME));
        Jobs newJobs = jobRepository.save(jobs);
        logger.info("Job added successfully: {}", newJobs);
        return newJobs;
    }

    @Override
    public Jobs viewJobs(long jobId) {
        logger.info("Viewing job with ID: {}", jobId);
        Jobs jobs = jobRepository.findById(jobId)
                .orElseThrow(() -> {
                    logger.error("Job not found with ID: {}", jobId);
                    return new JobNotFoundException("Job not found with Id: " + jobId);
                });
        return jobs;
    }

    @Override
    public List<Jobs> searchByLocation(String location) {
        logger.info("Searching jobs by location: {}", location);
        List<Jobs> jobs = jobRepository.findByLocation(location);
        if (jobs.isEmpty()) {
            logger.warn("No jobs found in the location: {}", location);
            throw new JobNotFoundException("No jobs found in the location: " + location);
        }
        return jobs;
    }

    @Override
    public Jobs deleteJob(long jobId) {
        logger.info("Deleting job with ID: {}", jobId);
        Jobs job = jobRepository.findById(jobId)
                .orElseThrow(() -> {
                    logger.error("Job not found with ID: {}", jobId);
                    return new JobNotFoundException("Job not found with Id: " + jobId);
                });
        jobRepository.delete(job);
        logger.info("Job deleted successfully: {}", job);
        return job;
    }

    @Override
    public List<Jobs> searchByJobtitle(String jobTitle) {
        logger.info("Searching jobs by title: {}", jobTitle);
        List<Jobs> jobs = jobRepository.findByJobTitle(jobTitle);
        if (jobs.isEmpty()) {
            logger.warn("No jobs found with title: {}", jobTitle);
            throw new JobNotFoundException("No jobs found with title: " + jobTitle);
        }
        return jobs;
    }

}
