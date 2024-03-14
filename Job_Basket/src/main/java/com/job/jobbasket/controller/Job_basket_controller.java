package com.job.jobbasket.controller;

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

import com.job.jobbasket.model.Job_Basket;
import com.job.jobbasket.service.JobbasketService;

@RestController
@RequestMapping("job_basket")
public class Job_basket_controller {

	@Autowired
	private JobbasketService jobbasketService;

	@PostMapping("/addBasket")
	public ResponseEntity<Job_Basket> addtobasket(@RequestBody Job_Basket newBasket) {
		Job_Basket basket = jobbasketService.addtobasket(newBasket);
		return new ResponseEntity<Job_Basket>(basket, HttpStatus.CREATED);
	}

	@GetMapping("/viewbasket/{userId}")
	public ResponseEntity<List<Job_Basket>> viewbasket(@PathVariable long userId) {
		List<Job_Basket> baskets = jobbasketService.viewbasket(userId);
		return new ResponseEntity<List<Job_Basket>>(baskets, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/remove/{jobbasketId}")
	public ResponseEntity<String> removebasket(@PathVariable long jobbasketId) {
		return new ResponseEntity<String>(jobbasketService.removebasket(jobbasketId), HttpStatus.ACCEPTED);
	}
	

}
