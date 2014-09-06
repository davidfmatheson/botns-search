package com.mathesonconsulting.botns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesonconsulting.botns.domain.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
	List<BookEntity> findByTitle(String title);
}
