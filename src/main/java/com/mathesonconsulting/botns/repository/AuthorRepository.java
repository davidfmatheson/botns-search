package com.mathesonconsulting.botns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesonconsulting.botns.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	List<Author> findByLastName(String lastName);
}
