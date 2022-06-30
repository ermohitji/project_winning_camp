package com.example.minor.project.demominorproject1may.requestmodels;

import com.example.minor.project.demominorproject1may.entity.Author;
import com.example.minor.project.demominorproject1may.entity.Book;
import com.example.minor.project.demominorproject1may.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookCreateRequest {

	private String name;

	private int cost;

	private String authorName;

	private Category category;

	private String email;

	public Book to() {

		Author author = Author.builder().name(authorName).email(email).build();

		return Book.builder().name(name).cost(cost).category(category).author(author).build();

	}

}
