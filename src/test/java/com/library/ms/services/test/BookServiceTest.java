package com.library.ms.services.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.library.ms.dto.response.GenericResponseDTO;
import com.library.ms.mock.builder.MockBuilder;
import com.library.ms.repositories.AdminRepository;
import com.library.ms.repositories.BookRepository;
import com.library.ms.repositories.UserRepository;
import com.library.ms.services.BookService;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest extends MockBuilder {

	@InjectMocks
	private BookService service;

	@Mock
	private UserRepository userRepository;

	@Mock
	private BookRepository bookRepository;

	@Mock
	private AdminRepository adminRepository;

	@Test
	public void shouldReturnBook() {
		Mockito.when(userRepository.findByName(rentBookRequest().getUsername())).thenReturn(buildUser().get());
		Mockito.when(bookRepository.findBookByTitleAndChecksIfRented(rentBookRequest().getTitle())).thenReturn(book());
		GenericResponseDTO response = service.returnsBook(rentBookRequest());
		assertNotNull(response);
	}

	@Test
	public void shouldRentBook() {

		Mockito.when(userRepository.findByName(rentBookRequest().getUsername())).thenReturn(buildUserTwo().get());
		Mockito.when(bookRepository.findBookByTitleAndChecksIfNotRented(rentBookRequest().getTitle()))
				.thenReturn(bookThree());
		GenericResponseDTO response = service.rentsBook(rentBookRequest());
		assertNotNull(response);
	}

}
