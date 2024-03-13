package com.job.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.job.security.model.AuthRequest;
import com.job.security.model.Userinfo;
import com.job.security.service.JwtService;
import com.job.security.service.UserInfoService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring Security tutorials !!";
	}

	@PostMapping("/Register")
	public Userinfo addUser(@Valid @RequestBody Userinfo userInfo) {
		return userInfoService.addUser(userInfo);

	}

	@PostMapping("/login")
	public String addUser(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		if (authenticate.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid user request");
		}
	}

	@GetMapping("/getUsers")
	@PreAuthorize("hasAuthority('employer')")
	public List<Userinfo> getAllUsers() {
		return userInfoService.getAllUser();
	}

	@GetMapping("/getUsers/{id}")
	@PreAuthorize("hasAuthority('employer')")
	public Userinfo getAllUsers(@PathVariable("userId") long userId) {
		return userInfoService.getUser(userId);
	}

	@GetMapping("listofjobseekers/{skillSet}")
	@PreAuthorize("hasAuthority('employer')")
	public ResponseEntity<HashMap<String, List<Userinfo>>> listofusersbyskillset(
			@PathVariable("skillSet") String skillSet) {
		HashMap<String, List<Userinfo>> userinfo = userInfoService.searchBySkillSet(skillSet);
		return new ResponseEntity<HashMap<String, List<Userinfo>>>(userinfo, HttpStatus.ACCEPTED);
	}
}
