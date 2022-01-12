package com.library.ms.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@Builder
public class AdminEntity {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "profile")
	private String profile;

	@Column(name = "createdTime")
	private Date createdTime;

	@Column(name = "isActive")
	private boolean isActive;
	
	@Column(name = "rented_books")
	@ElementCollection(targetClass=BookEntity.class)
	private List<BookEntity> rentedBooks;

}
