package com.example.minor.project.demominorproject1may.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.minor.project.demominorproject1may.entity.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

/*	//JPQL way
	@Query(value = "select a from Author a where a.id=:id")
	Author findAuthor(int id);
	
	//is native query way
	@Query(value = "select * from author where email=:email", nativeQuery = true)
	Author findAuthor(String email);
	
	
	//suppose if the query has multiple parameter 
	
	@Query(value="select a from Author a where a.name=:name and a.email = :email")
	Author findAuthorByNameAndEmail(String name, String email);*/
	
	
	@Query(value = "select a from Author a where a.email=:email")
	Author findAuthor(@Param(value = "email") String email);
	
	
	
	
	
}








//jpql - java persitence query language 
// format excutes query considering java classes this doesnot have anything to do with sql table column name


//Native query 
//format executes considering your sql table