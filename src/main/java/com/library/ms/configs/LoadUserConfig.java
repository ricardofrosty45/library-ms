package com.library.ms.configs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.library.ms.repositories.UserRepository;
import com.library.ms.utils.UserUtil;

@Configuration
public class LoadUserConfig {

	private final UserRepository repository;

	@Autowired
	public LoadUserConfig(UserRepository repository) {
		this.repository = repository;
	}

	@PostConstruct
	public void createsNewUsersIntoDatabase() {
		repository.saveAll(UserUtil.createsUser());
	}

}
