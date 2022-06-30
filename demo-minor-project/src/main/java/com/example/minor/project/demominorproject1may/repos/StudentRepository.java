package com.example.minor.project.demominorproject1may.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minor.project.demominorproject1may.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
