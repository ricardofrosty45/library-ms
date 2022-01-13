package com.library.ms.controllers;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.ms.dto.request.BookRequestDTO;
import com.library.ms.dto.response.ErrorResponse;
import com.library.ms.dto.response.GenericResponseDTO;
import com.library.ms.entities.UserEntity;
import com.library.ms.services.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/v1/admin")
@Tag(name = "Admin", description = "Service responsible for ADMIN services")
@RequiredArgsConstructor
public class AdminController {

	private final AdminService service;

	@Operation(summary = "Get's all active users", description = "This endpoint will get all active users for the library", tags = {
			"Admin" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserEntity.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "503", description = "Service Unavailable", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(service.getAllActiveUsers(), HttpStatus.OK);
	}

	@Operation(summary = "Get's all admins", description = "This endpoint will get all admins", tags = {
			"Admin" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = UserEntity.class))),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "503", description = "Service Unavailable", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
	@GetMapping("/all")
	public ResponseEntity<?> getAllAdmins() {
		return new ResponseEntity<>(service.getAllActiveUsers(), HttpStatus.OK);
	}

	@Operation(summary = "Inactives a user", description = "This endpoint will inactivates a user", tags = { "Admin" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = GenericResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "503", description = "Service Unavailable", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
	@PutMapping("/inactive/user/{userId}")
	public ResponseEntity<?> makesUserInactive(
			@NotNull(message = "userId cannot be null") @NotBlank(message = "userId cannot be empty, please inform us a valid userId") @PathVariable final String userId) {
		return new ResponseEntity<>(service.makesUserInactive(userId), HttpStatus.OK);
	}

	@Operation(summary = "Creates and register a new book", description = "This endpoint will register and create a new book", tags = {
			"Admin" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = GenericResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "503", description = "Service Unavailable", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
	@PostMapping("/book")
	public ResponseEntity<?> createsAndRegisterNewBook(@Valid @RequestBody final BookRequestDTO request) {
		return new ResponseEntity<>(service.createsAndRegisterNewBook(request), HttpStatus.CREATED);
	}

	@Operation(summary = "Deletes a book from database", description = "This endpoint will register and create a new book", tags = {
			"Admin" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = GenericResponseDTO.class))),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
			@ApiResponse(responseCode = "503", description = "Service Unavailable", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
	@DeleteMapping("/book/{bookName}")
	public ResponseEntity<?> removesBook(
			@NotNull(message = "bookName cannot be null") @NotBlank(message = "bookName cannot be empty, please inform us a valid bookName") @PathVariable final String bookName) {
		return new ResponseEntity<>(service.removesBook(bookName), HttpStatus.OK);
	}

}
