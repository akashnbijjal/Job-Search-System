package com.job.security.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.job.security.model.Userinfo;
import com.job.security.repository.UserRepository;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private UserRepository userInfoRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Userinfo> userInfo = userInfoRepository.findByUsername(username);
		return userInfo.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
	}

	public Userinfo addUser(Userinfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfo.setUserId(sequenceGeneratorService.generateSequence(Userinfo.SEQUENCE_NAME));
		userInfoRepository.save(userInfo);
		System.out.println(userInfo);
		return userInfo;
	}

	public List<Userinfo> getAllUser() {
		return userInfoRepository.findAll();
	}

	public Userinfo getUser(long id) {
		return userInfoRepository.findById(id).get();
	}

	public HashMap<String, List<Userinfo>> searchBySkillSet(String skillSet) {
        List<Userinfo> jobSeekers = userInfoRepository.findAllBySkillSetContainingAndRoles(skillSet, "jobseeker");

        HashMap<String, List<Userinfo>> resultMap = new HashMap<>();
        resultMap.put(skillSet, jobSeekers);
        return resultMap;
    }
}