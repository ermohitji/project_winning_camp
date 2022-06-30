package com.example.minor.project.demominorproject1may.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.minor.project.demominorproject1may.entity.Author;
import com.example.minor.project.demominorproject1may.repos.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	public Author createOrGetAuthor(Author author) {

		Author authorFromDb = authorRepository.findAuthor(author.getEmail());

		if (authorFromDb == null) {
			authorFromDb = authorRepository.save(author);

		}

		return authorFromDb;

	}

}
