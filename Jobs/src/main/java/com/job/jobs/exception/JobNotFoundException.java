package com.job.jobs.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String msg;
}
