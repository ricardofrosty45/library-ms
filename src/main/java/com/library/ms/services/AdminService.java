package com.library.ms.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.QueryTimeoutException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.library.ms.dto.request.BookRequestDTO;
import com.library.ms.dto.response.GenericResponseDTO;
import com.library.ms.entities.BookEntity;
import com.library.ms.entities.UserEntity;
import com.library.ms.exceptions.BookException;
import com.library.ms.exceptions.UserException;
import com.library.ms.repositories.BookRepository;
import com.library.ms.repositories.UserRepository;
import com.library.ms.utils.ExceptionUtil;

@Service
public class AdminService {

	private final UserRepository userRepository;

	private final BookRepository bookRepository;

	@Autowired
	public AdminService(UserRepository repository, BookRepository bookRepository) {
		this.userRepository = repository;
		this.bookRepository = bookRepository;
	}

	@Retryable(include = { JDBCConnectionException.class,
			QueryTimeoutException.class }, maxAttempts = 4, backoff = @Backoff(delay = 4000))
	public List<UserEntity> getAllActiveUsers() {
		return Optional.ofNullable(userRepository.findAllActiveUser())
				.orElseThrow(ExceptionUtil.throwsSupplierClientException("There's no active users"));
	}

	@Retryable(include = { JDBCConnectionException.class,
			QueryTimeoutException.class }, maxAttempts = 4, backoff = @Backoff(delay = 4000))
	public GenericResponseDTO makesUserInactive(String userId) {
		userRepository.findById(userId).ifPresentOrElse(user -> {
			user.setActive(false);
			userRepository.save(user);
		}, () -> {
			throw new UserException("Couldn't inactivate user because user does not exist.");
		});
		return GenericResponseDTO.builder().message("User Deactivated").build();
	}

	@Retryable(include = { JDBCConnectionException.class,
			QueryTimeoutException.class }, maxAttempts = 4, backoff = @Backoff(delay = 4000))
	public GenericResponseDTO createsAndRegisterNewBook(BookRequestDTO request) {
		bookRepository.save(BookEntity.builder().title(request.getTitle()).category(request.getCategory())
				.bookExamples(request.getBookExamples()).build());
		return GenericResponseDTO.builder().message("Book registered!").build();
	}
	
	@Retryable(include = { JDBCConnectionException.class,
			QueryTimeoutException.class }, maxAttempts = 4, backoff = @Backoff(delay = 4000))
	public GenericResponseDTO removesBook(String bookName) {
		Optional.ofNullable(bookRepository.findBookByTitleAndChecksIfNotRented(bookName)).ifPresentOrElse(book ->{
			bookRepository.delete(book);
		}, () -> {
			throw new BookException("Book couldn't be deleted, book doesn't exist.");
		});
		return GenericResponseDTO.builder().message("Book deleted!").build();
	}


}
