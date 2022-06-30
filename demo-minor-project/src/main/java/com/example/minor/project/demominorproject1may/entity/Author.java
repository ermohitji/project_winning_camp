package com.example.minor.project.demominorproject1may.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.minor.project.demominorproject1may.requestmodels.BookCreateRequest;
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
public class Author {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private String name;

	@OneToMany(mappedBy = "author")
	@JsonIgnoreProperties(value = "author")
	private List<Book> book;

	private int age;

	@Column(unique = true, nullable = false)
	private String email;

}

// mapped by is mainly for back reference
// it does hibernate intenral joins and create join queries etc.