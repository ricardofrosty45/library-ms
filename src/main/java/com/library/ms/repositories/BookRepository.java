package com.library.ms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.ms.entities.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> { 
	
	@Query(value = "select * from book where is_rented = false", nativeQuery = true)
	List<BookEntity> findAllNotRentedBooks();

	@Query(value = "select * from book where title = \"title\" and is_rented = false", nativeQuery = true)
	BookEntity findBookByTitleAndChecksIfNotRented(@Param("title") String title);

}
