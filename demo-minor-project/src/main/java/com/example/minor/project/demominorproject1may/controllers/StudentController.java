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

import com.example.minor.project.demominorproject1may.entity.Student;
import com.example.minor.project.demominorproject1may.service.StudentSerivce;

@RestController
public class StudentController {

	@Autowired
	StudentSerivce studentService;

	@PostMapping("/student")
	public void createStudent(@RequestBody Student student) {

		studentService.createStudent(student);
	}

	@GetMapping("/students/all")
	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}

	@PutMapping("/student/update")
	public void updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
	}

	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {
		return studentService.getStudentById(studentId);
	}

}
