package com.example.minor.project.demominorproject1may.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	private String name;

	private int age;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = true)
	private String phoneNumber;

	@OneToMany(mappedBy = "student")
	@JsonIgnoreProperties(value = "student")
	private List<Book> book;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOne;
	
	@OneToMany(mappedBy="student")
	@JsonIgnoreProperties(value = "student")
	private List<Transaction> transaction;
	
	
	

}

// mapped by is always current class ref attribute in the other class

// uni drirectional way ----
// bidirectional way -------