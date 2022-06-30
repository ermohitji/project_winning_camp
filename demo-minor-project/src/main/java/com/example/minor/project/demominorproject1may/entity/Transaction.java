package com.example.minor.project.demominorproject1may.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.minor.project.demominorproject1may.requestmodels.TransactionStatus;
import com.example.minor.project.demominorproject1may.requestmodels.TransactionType;
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
public class Transaction {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	private String transactionId;

	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "transaction")
	private Student student;

	@Enumerated(value = EnumType.STRING)
	TransactionStatus transactionStatus;

	@Enumerated(value = EnumType.STRING)
	TransactionType transactionType;

	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "transaction")
	private Book book;

	private Integer fine;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOne;

}
