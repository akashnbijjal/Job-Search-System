package com.job.jobbasket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.jobbasket.feign.Jobsfeign;
import com.job.jobbasket.model.Job_Basket;
import com.job.jobbasket.model.Jobs;
import com.job.jobbasket.repository.JobbasketRepository;

@Service
public class JobbasketServiceImpl implements JobbasketService {

	@Autowired
	private JobbasketRepository jobbasketRepository;

	@Autowired
	private Jobsfeign jobsfeign;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public Job_Basket addtobasket(Job_Basket newBasket) {
		newBasket.setJobbasketId(sequenceGeneratorService.generateSequence(Job_Basket.SEQUENCE_NAME));
		Jobs jobs = jobsfeign.viewJobs(newBasket.getJobId()).getBody();
		newBasket.setJobTitle(jobs.getJobTitle());
		newBasket.setLocation(jobs.getLocation());
		newBasket.setDescription(jobs.getDescription());
		newBasket.setExperience(jobs.getExperience());
		newBasket.setSalary(jobs.getSalary());
		newBasket.setNoticePeriod(jobs.getNoticePeriod());
		newBasket.setContactEmail(jobs.getContactEmail());
		newBasket.setStatus(jobs.getStatus());
		newBasket.setCompanyName(jobs.getCompanyName());
		newBasket.setIndustry(jobs.getIndustry());
		newBasket.setEmploymentType(jobs.getEmploymentType());
		newBasket.setEducationLevel(jobs.getEducationLevel());
		newBasket.setSkillsRequired(jobs.getSkillsRequired());
		Job_Basket basket = jobbasketRepository.save(newBasket);
		return basket;
	}

	@Override
	public List<Job_Basket> viewbasket(long userId) {
		List<Job_Basket> list = jobbasketRepository.findAllByUserId(userId);
		return list;
	}

	@Override
	public String removebasket(long jobbasketId) {
		jobbasketRepository.deleteById(jobbasketId);
		return "deleted successfully";
	}

}
