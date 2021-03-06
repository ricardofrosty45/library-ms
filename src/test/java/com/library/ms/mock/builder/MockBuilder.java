package com.library.ms.mock.builder;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.library.ms.dto.request.BookRequestDTO;
import com.library.ms.dto.request.RentOrReturnBookRequestDTO;
import com.library.ms.entities.AdminEntity;
import com.library.ms.entities.BookEntity;
import com.library.ms.entities.UserEntity;

public abstract class MockBuilder {

	protected final String USER_ID = "123";

	protected final String USER_INACTIVE_MESSAGE = "User Deactivated";

	protected final String INACTIVATE_USER_ENDPOINT = "/v1/admin/inactive/user/";

	protected final String GET_ALL_USER_ENDPOINT = "/v1/admin/users";

	protected final String CREATE_BOOK_MESSAGE = "Book deleted!";

	protected final String CREATE_BOOK_ENDPOINT = "/v1/admin/book";

	protected final String DELETE_BOOK_ENDPOINT = "/v1/admin/book/testBook";

	protected final String DELETE_BOOK_MESSAGE = "Book deleted!";

	protected final String GET_ALL_BOOKS_ENDPOINT = "/v1/book";

	protected final String RENT_BOOK_ENDPOINT = "/v1/book/rent";

	protected final String RENT_BOOK_MESSAGE = "Book Rented!";

	protected final String RETURNED_BOOK_MESSAGE = "Book Returned!";

	protected final String RETURN_BOOK_ENDPOINT = "/v1/book/return";

	protected final List<UserEntity> usersList() {

		byte[] array = new byte[7];
		new Random().nextBytes(array);

		List<UserEntity> users = new ArrayList<>();
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("potwog@omdlism.com")
				.createdTime(new Date()).isActive(true).profile("Profile 1").build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("tacs@midtoys.com")
				.createdTime(new Date()).isActive(true).profile("Profile 2").build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("mathewj@rewtorsfo.ru")
				.createdTime(new Date()).isActive(true).profile(new String(array, Charset.forName("UTF-8"))).build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("funz@tyonyihi.com")
				.createdTime(new Date()).isActive(true).profile("Profile 4").build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("brujje@rentz.fun")
				.createdTime(new Date()).isActive(true).profile("Profile 5").build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8")))
				.email("kiselksana@toyotataganka.ru").createdTime(new Date()).isActive(true)
				.profile(new String(array, Charset.forName("UTF-8"))).build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("huntermi@riniiya.com")
				.createdTime(new Date()).isActive(true).profile(new String(array, Charset.forName("UTF-8"))).build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8")))
				.email("tonysutherland@hacktoy.com").createdTime(new Date()).isActive(true)
				.profile(new String(array, Charset.forName("UTF-8"))).build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("reshelena@btcmod.com")
				.createdTime(new Date()).isActive(true).profile("Profile 9").build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("dxp9284d@litec.site")
				.createdTime(new Date()).isActive(true).profile("Profile 10").build());
		users.add(UserEntity.builder().name(new String(array, Charset.forName("UTF-8")))
				.email("ctobiassilva@anatolygroup.com").createdTime(new Date()).isActive(true).profile("Profile 11")
				.build());
		users.add(
				UserEntity.builder().name(new String(array, Charset.forName("UTF-8"))).email("gabrielmessi30@outluk.co")
						.createdTime(new Date()).isActive(true).profile("Profile 12").build());

		return users;

	}

	protected final List<BookEntity> bookList() {

		List<BookEntity> books = new ArrayList<>();
		books.add(BookEntity.builder().bookExamples("123").category("123").isRented(false).title("123").build());
		books.add(BookEntity.builder().bookExamples("123").category("123").isRented(false).title("123").build());
		books.add(BookEntity.builder().bookExamples("123").category("123").isRented(false).title("123").build());
		books.add(BookEntity.builder().bookExamples("123").category("123").isRented(false).title("123").build());
		books.add(BookEntity.builder().bookExamples("123").category("123").isRented(false).title("123").build());
		books.add(BookEntity.builder().bookExamples("123").category("123").isRented(false).title("123").build());
		return books;

	}

	protected final BookRequestDTO createNewBookRequest() {
		BookRequestDTO request = new BookRequestDTO();
		request.setBookExamples("123");
		request.setCategory("123");
		request.setTitle("123");
		return request;

	}

	protected final RentOrReturnBookRequestDTO rentBookRequest() {
		RentOrReturnBookRequestDTO request = new RentOrReturnBookRequestDTO();
		request.setEvent("user");
		request.setUsername("123");
		request.setTitle("123");
		return request;

	}


	protected final BookEntity book() {

		return BookEntity.builder().title("123").category("123").bookExamples("123").isRented(true).build();
	}
	
	protected final BookEntity bookTwo() {

		return BookEntity.builder().title("123").category("123").bookExamples("123").isRented(false).build();
	}
	
	
	protected final BookEntity bookThree() {

		return BookEntity.builder().title("123").category("123").bookExamples("123").isRented(false).build();
	}

	protected final Optional<UserEntity> buildUser() {
		List<BookEntity> books = new ArrayList<BookEntity>();
		books.add(bookTwo());
		books.add(book());
		Optional<UserEntity> op = Optional.of(UserEntity.builder().email("Email").rentedBooks(books).build());

		return op;

	}
	
	protected final Optional<UserEntity> buildUserTwo() {
		List<BookEntity> books = new ArrayList<BookEntity>();
		books.add(bookThree());
		Optional<UserEntity> op = Optional.of(UserEntity.builder().email("Email").rentedBooks(books).build());

		return op;

	}
	
	protected final Optional<AdminEntity> buildAdmin() {
		List<BookEntity> books = new ArrayList<BookEntity>();
		books.add(bookThree());
		Optional<AdminEntity> op = Optional.of(AdminEntity.builder().email("Email").name("123").rentedBooks(books).build());

		return op;

	}
	
	
	protected final AdminEntity buildAdminTwo() {
		List<BookEntity> books = new ArrayList<BookEntity>();
		books.add(bookThree());

		return AdminEntity.builder().email("Email").name("123").rentedBooks(books).build();

	}

}
