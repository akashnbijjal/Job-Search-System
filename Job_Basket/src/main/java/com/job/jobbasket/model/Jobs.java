package com.job.jobbasket.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jobs {

	@Id
	private long jobId;

	private String jobTitle;

	private String location;

	private String description;

	private double experience;

	private double salary;

	private String noticePeriod;

	private String contactEmail;

	private String status;

	private String companyName;

	private String industry;

	private String employmentType;

	private String educationLevel;

	private List<String> skillsRequired;

}
