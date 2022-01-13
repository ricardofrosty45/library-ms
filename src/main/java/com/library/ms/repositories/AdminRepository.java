package com.library.ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.ms.entities.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, String>{
	
	AdminEntity findByName(@Param("name")String username);

}
