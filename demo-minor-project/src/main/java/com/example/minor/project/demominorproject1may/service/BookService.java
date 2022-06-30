package com.example.minor.project.demominorproject1may.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minor.project.demominorproject1may.entity.Author;
import com.example.minor.project.demominorproject1may.entity.Book;
import com.example.minor.project.demominorproject1may.entity.Student;
import com.example.minor.project.demominorproject1may.repos.AuthorRepository;
import com.example.minor.project.demominorproject1may.repos.BookRepository;

@Service
public class BookService {

	@Autowired
	AuthorService authorService;

	@Autowired
	BookRepository bookRepository;

	public void createBook(Book book) {

		Author author = authorService.createOrGetAuthor(book.getAuthor());
		book.setAuthor(author);
		bookRepository.save(book);

	}

	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub

	}
	
	public Book getBookById(int bookId) {

		return bookRepository.findById(bookId).orElse(null);
	}

}
