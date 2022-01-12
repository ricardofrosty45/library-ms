package com.library.ms.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.ms.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	@Query(value = "select * user where isActive = true", nativeQuery = true)
	List<UserEntity> findAllActiveUser();
}
