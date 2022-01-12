package com.library.ms.configs;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.library.ms.repositories.AdminRepository;
import com.library.ms.utils.UserUtil;

@Configuration
public class LoadAdminConfig {
	
	private final AdminRepository repository;

	@Autowired
	public LoadAdminConfig(AdminRepository repository) {
		this.repository = repository;
	}
	
	@PostConstruct
	public void createsNewUsersIntoDatabase() {
		repository.saveAll(UserUtil.createsAdmin());
	}
	
}
