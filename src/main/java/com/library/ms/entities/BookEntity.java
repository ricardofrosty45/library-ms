package com.library.ms.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@Builder
public class BookEntity {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "title")
	private String title;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "book_examples")
	private String bookExamples;
	
	@Column(name = "isRented")
	private boolean isRented;
	
	public BookEntity() {
	}

}
