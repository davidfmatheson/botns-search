package com.mathesonconsulting.botns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesonconsulting.botns.domain.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitle(String title);
}
