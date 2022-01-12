package com.library.ms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.ms.entities.BookEntity;
import com.library.ms.repositories.BookRepository;
import com.library.ms.utils.ExceptionUtil;

@Service
public class BookService {

	private final BookRepository repository;

	@Autowired
	public BookService(BookRepository repository) {
		this.repository = repository;
	}

	public List<BookEntity> getsAllNotRentedBooks() {
		return Optional.ofNullable(repository.findAllNotRentedBooks()).orElseThrow(ExceptionUtil
				.throwsSupplierClientException("All books are rented! please come back and check it later!"));
	}

}
