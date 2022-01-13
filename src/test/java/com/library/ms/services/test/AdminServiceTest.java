package com.library.ms.services.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.library.ms.dto.response.GenericResponseDTO;
import com.library.ms.entities.UserEntity;
import com.library.ms.mock.builder.MockBuilder;
import com.library.ms.repositories.BookRepository;
import com.library.ms.repositories.UserRepository;
import com.library.ms.services.AdminService;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class AdminServiceTest extends MockBuilder {

	@InjectMocks
	private AdminService service;

	@Mock
	private UserRepository userRepository;

	@Mock
	private BookRepository bookRepository;

	@Test
	public void shouldGetsAllActiveUsers() {
		Mockito.when(userRepository.findAllActiveUser()).thenReturn(usersList());
		List<UserEntity> users = service.getAllActiveUsers();
		assertNotNull(users);
	}

	@Test
	public void shouldInactivateUser() {
		String id = "02926464-5af1-434a-9e40-a05c92e1bc2e";
		Mockito.when(userRepository.findById(id)).thenReturn(buildUser());
		GenericResponseDTO inactive = service.makesUserInactive(id);
		assertNotNull(inactive);
	}

	@Test
	public void shouldSaveBook() {
		Mockito.when(bookRepository.save(book())).thenReturn(book());
		GenericResponseDTO inactive = service.createsAndRegisterNewBook(createNewBookRequest());
		assertNotNull(inactive);
	}

	@Test
	public void shouldRemoveBook() {
		GenericResponseDTO deletedBook = service.createsAndRegisterNewBook(createNewBookRequest());
		assertNotNull(deletedBook);
	}

}
