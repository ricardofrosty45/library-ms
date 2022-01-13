package com.library.ms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.ms.dto.request.RentOrReturnBookRequestDTO;
import com.library.ms.dto.response.GenericResponseDTO;
import com.library.ms.entities.AdminEntity;
import com.library.ms.entities.BookEntity;
import com.library.ms.entities.UserEntity;
import com.library.ms.exceptions.BookException;
import com.library.ms.repositories.AdminRepository;
import com.library.ms.repositories.BookRepository;
import com.library.ms.repositories.UserRepository;
import com.library.ms.utils.ExceptionUtil;

@Service
public class BookService {

	private final BookRepository bookRepository;

	private final UserRepository userRepository;

	private final AdminRepository adminRepository;

	@Autowired
	public BookService(BookRepository repository, UserRepository userRepository, AdminRepository adminRepository) {
		this.bookRepository = repository;
		this.userRepository = userRepository;
		this.adminRepository = adminRepository;
	}

	public List<BookEntity> getsAllNotRentedBooks() {
		return Optional.ofNullable(bookRepository.findAllNotRentedBooks()).orElseThrow(ExceptionUtil
				.throwsSupplierClientException("All books are rented! please come back and check it later!"));
	}

	public GenericResponseDTO returnsBook(RentOrReturnBookRequestDTO request) {

		BookEntity book = bookRepository.findBookByTitleAndChecksIfRented(request.getTitle());
		Optional.ofNullable(book).ifPresentOrElse(rentedBook -> {
			if (rentedBook.isRented()) {
				Map<String, Runnable> eventByTypeOfUser = Map.of("admin",
						() -> this.returnsAdminBookEvent(book, adminRepository.findByName(request.getUsername())),
						"user",
						() -> this.returnsUserBookEvent(book, userRepository.findByName(request.getUsername())));
				eventByTypeOfUser.get(request.getEvent()).run();
			} else {
				throw new BookException("Book is not rented");
			}

		}, () -> {
			throw new BookException("Book doesn't exist in our database");
		});

		return GenericResponseDTO.builder().message("Book Returned!").build();
	}

	public GenericResponseDTO rentsBook(RentOrReturnBookRequestDTO request) {

		BookEntity book = bookRepository.findBookByTitleAndChecksIfNotRented(request.getTitle());
		Optional.ofNullable(book).ifPresentOrElse(rentedBook -> {
			if (!rentedBook.isRented()) {
				Map<String, Runnable> eventByTypeOfUser = Map.of("admin",
						() -> this.rentsBookByEventAdmin(book, adminRepository.findByName(request.getUsername())),
						"user",
						() -> this.rentsBookByEventUser(book, userRepository.findByName(request.getUsername())));
				eventByTypeOfUser.get(request.getEvent()).run();
			} else {
				throw new BookException("Book is already rented!");
			}

		}, () -> {
			throw new BookException("Book doesn't exist in our database");
		});

		return GenericResponseDTO.builder().message("Book Rented!").build();
	}

	public void returnsAdminBookEvent(BookEntity book, AdminEntity entity) {
		book.setRented(false);
		entity.getRentedBooks().remove(book);
		adminRepository.save(entity);
	}

	public void returnsUserBookEvent(BookEntity book, UserEntity entity) {
		book.setRented(false);
		entity.getRentedBooks().remove(book);
		userRepository.save(entity);
	}

	public void rentsBookByEventAdmin(BookEntity book, AdminEntity entity) {

		if (!entity.getRentedBooks().isEmpty()) {
			book.setRented(true);
			List<BookEntity> books = entity.getRentedBooks();
			books.add(book);
			entity.setRentedBooks(books);
			adminRepository.save(entity);
		} else {
			book.setRented(true);
			List<BookEntity> books = new ArrayList<BookEntity>();
			books.add(book);
			entity.setRentedBooks(books);
			adminRepository.save(entity);
		}
	}

	public void rentsBookByEventUser(BookEntity book, UserEntity entity) {

		if (!entity.getRentedBooks().isEmpty()) {
			List<BookEntity> books = entity.getRentedBooks();
			book.setRented(true);
			books.add(book);
			entity.setRentedBooks(books);
			userRepository.save(entity);
		} else {
			List<BookEntity> books = new ArrayList<>();
			book.setRented(true);
			books.add(book);
			entity.setRentedBooks(books);
			userRepository.save(entity);
		}

	}

}
