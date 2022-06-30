package com.example.minor.project.demominorproject1may.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.minor.project.demominorproject1may.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	// we want to issue the book and return the book

	// issue book

	@PostMapping("/transaction/issue")
	public String issueBook(@RequestParam("bookId") int bookId, @RequestParam("studentId") int studentId) throws Exception {

		return transactionService.issueBook(bookId, studentId);
	}

	@PostMapping("/transaction/return")
	public String returnBook(@RequestParam("bookId") int bookId, @RequestParam("studentId") int studentId) throws Exception {

		return transactionService.returnBook(bookId, studentId);
	}

}
