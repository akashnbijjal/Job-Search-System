package com.job.jobbasket.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "job_basket")
public class Job_Basket {

	@Transient
	public static final String SEQUENCE_NAME = "jobbasket_sequence";

	@Id
	private long jobbasketId;

	private long jobId;

	private long userId;

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