package com.example.minor.project.demominorproject1may.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minor.project.demominorproject1may.entity.Book;
import com.example.minor.project.demominorproject1may.entity.Student;
import com.example.minor.project.demominorproject1may.entity.Transaction;
import com.example.minor.project.demominorproject1may.requestmodels.TransactionType;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByBookAndStudentAndTransactionTypeOrderByIdDesc(Book book, Student student,
			TransactionType TransactionType);

}
