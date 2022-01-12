package com.library.ms.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BookRequestDTO {
	
	@NotNull(message = "Title cannot be null")
	@NotBlank(message = "Title cannot be empty, please inform us a valid title")
	private String title;
	
	@NotNull(message = "category cannot be null")
	@NotBlank(message = "category cannot be empty, please inform us a valid category")
	private String category;
	
	@NotNull(message = "book examples cannot be null")
	@NotBlank(message = "book examples cannot be empty, please inform us a valid book example")
	private String bookExamples;
	
	private boolean isRented = false;

}
