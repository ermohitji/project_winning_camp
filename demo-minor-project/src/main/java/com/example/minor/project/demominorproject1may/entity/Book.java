package com.example.minor.project.demominorproject1may.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private String name;

	private int cost;

	@Enumerated(value = EnumType.STRING)
	private Category category;

	private String isbn;

	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "book")
	private Author author;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOne;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "book")
	private Student student;
	
	
	
	@OneToMany(mappedBy="book")
	@JsonIgnoreProperties(value = "book")
	private List<Transaction> transaction;
	
	
}

// ManyToOne
// ManyToMany
// OneToOne
// OneToMany
