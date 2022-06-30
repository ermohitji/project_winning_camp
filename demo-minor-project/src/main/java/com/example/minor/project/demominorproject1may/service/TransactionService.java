package com.example.minor.project.demominorproject1may.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.minor.project.demominorproject1may.entity.Book;
import com.example.minor.project.demominorproject1may.entity.Student;
import com.example.minor.project.demominorproject1may.entity.Transaction;
import com.example.minor.project.demominorproject1may.repos.TransactionRepository;
import com.example.minor.project.demominorproject1may.requestmodels.TransactionStatus;
import com.example.minor.project.demominorproject1may.requestmodels.TransactionType;

@Service
public class TransactionService {

	@Autowired
	StudentSerivce studentSerivce;

	@Autowired
	BookService bookService;

	@Autowired
	TransactionRepository transactionRepository;

	@Value("${student.book.quota}")
	int studentBookQuota;

	@Value("${book.return.days}")
	int bookReturnDays;

	@Value("${book.fine.day}")
	int finePerDay;

	public String issueBook(int bookId, int studentId) throws Exception {

		// What all checks would be required
		// 1) student is present or not
		// 2) book is present or not and is available to be issued
		// 3) student quota have reached or not
		// 4) create a txn with pending status
		// 5) make the unavailable for other student once issued
		// 6) update the txn as successfull or complete

		Student student = studentSerivce.getStudentById(studentId);

		if (student == null) {
			throw new Exception("Student is not present, unable to issue the book");
		}

		if (student.getBook().size() >= studentBookQuota) {
			throw new Exception("Student has reached their quota, unable to issue the book");
		}

		Book book = bookService.getBookById(bookId);

		if (book.getStudent() != null) {
			throw new Exception("Book is already issued to some one, unable to issue the book");

		}

		Transaction transaction = Transaction.builder().book(book).student(student)
				.transactionType(TransactionType.ISSUE).transactionStatus(TransactionStatus.PENDING)
				.transactionId(UUID.randomUUID().toString()).build();

		transactionRepository.save(transaction);

		try {

			book.setStudent(student);

			bookService.createBook(book);

			transaction.setTransactionStatus(TransactionStatus.SUCCESS);

			transactionRepository.save(transaction);
		} catch (Exception e) {
			book.setStudent(null);

			bookService.createBook(book);

			transaction.setTransactionStatus(TransactionStatus.FAILED);

			transactionRepository.save(transaction);

		}

		return transaction.getTransactionId();

	}

	public String returnBook(int bookId, int studentId) throws Exception {
		// TODO Auto-generated method stub
		// 1) check whether book is assigned to student or not ?
		// 2) check the days diff and calulate the fine if any update
		// 3) create the txn with pending status
		// 4) make it availbale for other students and remove the current
		// assigned student
		// 5) update the tnx with success or complete

		Student student = studentSerivce.getStudentById(studentId);
		Book book = bookService.getBookById(bookId);

		if (student == null || book == null || book.getStudent() == null || book.getStudent().getId() != studentId) {
			throw new Exception(
					"Book or student iseither not present or book is not assigned to the student , unable to return the book");

		}

		List<Transaction> issueTxns = transactionRepository.findByBookAndStudentAndTransactionTypeOrderByIdDesc(book,
				student, TransactionType.ISSUE);

		Transaction issueTxn = issueTxns.get(0);

		long issueTimeInMillis = issueTxn.getUpdatedOne().getTime();
		long currentTimeInMillis = System.currentTimeMillis();

		long timeDiff = currentTimeInMillis - issueTimeInMillis;

		long numberOfDaysPassed = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

		int fine = 0;

		if (numberOfDaysPassed > bookReturnDays) {
			fine = (int) ((numberOfDaysPassed - bookReturnDays) * finePerDay);

		}

		Transaction transaction = Transaction.builder().book(book).student(student).fine(fine)
				.transactionType(TransactionType.RETURN).transactionStatus(TransactionStatus.PENDING)
				.transactionId(UUID.randomUUID().toString()).build();

		transactionRepository.save(transaction);

		try {

			book.setStudent(null);

			bookService.createBook(book);// will update as well

			transaction.setTransactionStatus(TransactionStatus.SUCCESS);

			transactionRepository.save(transaction);
		} catch (Exception e) {
			book.setStudent(student);

			bookService.createBook(book);

			transaction.setTransactionStatus(TransactionStatus.FAILED);

			transactionRepository.save(transaction);

		}

		return transaction.getTransactionId();

	}

}
