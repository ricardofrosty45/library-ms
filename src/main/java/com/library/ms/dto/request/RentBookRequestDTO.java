package com.library.ms.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RentBookRequestDTO {
	
	@NotNull(message = "Book title cannot be null")
	@NotBlank(message = "book title cannot be empty, please inform us a valid title")
	private String title;
	
	@NotNull(message = "username cannot be null")
	@NotBlank(message = "username cannot be empty, please inform us a valid username")
	private String username;
	
	@NotNull(message = "please event cannot be null")
	@NotBlank(message = "event cannot be empty, please inform if it's a user or admin")
	private String event;

}
