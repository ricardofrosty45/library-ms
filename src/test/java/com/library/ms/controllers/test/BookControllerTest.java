package com.library.ms.controllers.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.library.ms.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest extends MockBuilder {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService service;

	@Test
	void shouldGetAllAvaliableBooks() throws Exception {
		Mockito.when(service.getsAllNotRentedBooks()).thenReturn(this.bookList());
		mockMvc.perform(get(GET_ALL_BOOKS_ENDPOINT).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void shouldRentBook() throws Exception {
		Mockito.when(service.rentsBook(this.rentBookRequest()))
				.thenReturn(GenericResponseDTO.builder().message(RENT_BOOK_MESSAGE).build());
		mockMvc.perform(put(RENT_BOOK_ENDPOINT).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(this.rentBookRequest()))).andExpect(status().isOk());

	}

	@Test
	void shouldReturnBook() throws Exception {
		Mockito.when(service.returnsBook(this.rentBookRequest()))
				.thenReturn(GenericResponseDTO.builder().message(RETURNED_BOOK_MESSAGE).build());
		mockMvc.perform(put(RETURN_BOOK_ENDPOINT).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(this.rentBookRequest()))).andExpect(status().isOk());

	}

}
