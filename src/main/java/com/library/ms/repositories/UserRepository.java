package com.library.ms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.ms.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	
	@Query(value = "select * from user where is_active = true", nativeQuery = true)
	List<UserEntity> findAllActiveUser();
		
	UserEntity findByName(@Param("name")String username);
}
