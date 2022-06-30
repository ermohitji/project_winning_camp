package com.example.minor.project.demominorproject1may.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minor.project.demominorproject1may.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

}

