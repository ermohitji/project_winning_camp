
package com.example.minor.project.demominorproject1may.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.minor.project.demominorproject1may.entity.Author;
import com.example.minor.project.demominorproject1may.entity.Book;
import com.example.minor.project.demominorproject1may.requestmodels.BookCreateRequest;
import com.example.minor.project.demominorproject1may.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	
/*	
 * http://localhost:8080/book
 * {
		"name":"Math 212",
		"cost": 400,
		"authorName":"JK ROWLING 21",
		"category":"ACCOUNTS",
		"email":"william@gmail.com"
		}*/


	@PostMapping("/book")
	public void createBook(@RequestBody BookCreateRequest bookCreateRequest) {
		
		bookService.createBook(bookCreateRequest.to());
	}

	@GetMapping("/book/all")
	public List<Book> getBook() {
		return bookService.getAllBook();
	}

	@PutMapping("/book/update")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}



}
