package com.library.ms.configs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.library.ms.repositories.UserRepository;
import com.library.ms.utils.UserUtil;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadUserConfig {

	private final UserRepository repository;

	@Autowired
	public LoadUserConfig(UserRepository repository) {
		this.repository = repository;
	}

	@PostConstruct
	public void createsNewUsersIntoDatabase() {
		

		if(repository.findAll().equals(UserUtil.createsUser())) {
			log.error("Yep they're equals!! shouldn't insert!");
		}
		
		
		repository.saveAll(UserUtil.createsUser());
	}

}
