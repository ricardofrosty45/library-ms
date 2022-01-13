package com.library.ms.controllers.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.library.ms.dto.response.GenericResponseDTO;
import com.library.ms.mock.builder.MockBuilder;
import com.library.ms.services.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest extends MockBuilder {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminService service;

	@Test
	void shouldGetAllUsers() throws Exception {
		Mockito.when(service.getAllActiveUsers()).thenReturn(this.usersList());
		mockMvc.perform(get(GET_ALL_USER_ENDPOINT).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void shouldMakeUserInactive() throws Exception {
		Mockito.when(service.makesUserInactive(USER_ID))
				.thenReturn(GenericResponseDTO.builder().message(USER_INACTIVE_MESSAGE).build());
		mockMvc.perform(put(INACTIVATE_USER_ENDPOINT + USER_ID)).andExpect(status().isOk());
	}

	@Test
	void shouldRegisterNewBook() throws Exception {
		Mockito.when(service.createsAndRegisterNewBook(createNewBookRequest()))
				.thenReturn(GenericResponseDTO.builder().message(CREATE_BOOK_MESSAGE).build());
		mockMvc.perform(post(CREATE_BOOK_ENDPOINT).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(createNewBookRequest()))).andExpect(status().isCreated());
	}

	@Test
	void shouldDeleteBook() throws Exception {
		Mockito.when(service.removesBook("testBook"))
				.thenReturn(GenericResponseDTO.builder().message(DELETE_BOOK_MESSAGE).build());
		mockMvc.perform(delete(DELETE_BOOK_ENDPOINT)).andExpect(status().isOk());
	}

}
