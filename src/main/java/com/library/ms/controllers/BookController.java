package com.library.ms.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.ms.dto.request.RentOrReturnBookRequestDTO;
import com.library.ms.dto.response.ErrorResponse;
import com.library.ms.dto.response.GenericResponseDTO;
import com.library.ms.entities.BookEntity;
import com.library.ms.services.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/v1/book")
@Tag(name = "Book", description = "Service responsible for book services")
@RequiredArgsConstructor
public class BookController {

	private final BookService service;

	@Operation(summary = "Find avaliable books", description = "This endpoint will find avaliable books", tags = {
			"Book" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "503", description = "Service Unavaliable", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = BookEntity.class))) })
	@GetMapping
	public ResponseEntity<?> getsAllAvaliableBooks() {
		return new ResponseEntity<>(service.getsAllNotRentedBooks(), HttpStatus.OK);
	}

	@Operation(summary = "Rents a book", description = "This endpoint will rent a book", tags = { "Book" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "503", description = "Service Unavaliable", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = GenericResponseDTO.class))) })
	@PutMapping("/rent")
	public ResponseEntity<?> rentsBook(@Valid @RequestBody final RentOrReturnBookRequestDTO request, String bookId) {
		return new ResponseEntity<>(service.rentsBook(request), HttpStatus.OK);
	}

	@Operation(summary = "Returns a book", description = "This endpoint will return a book", tags = { "Book" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "503", description = "Service Unavaliable", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = GenericResponseDTO.class))) })
	@PutMapping("/return")
	public ResponseEntity<?> returnsBook(@Valid @RequestBody final RentOrReturnBookRequestDTO request) {
		return new ResponseEntity<>(service.returnsBook(request), HttpStatus.OK);
	}

}
