package com.mathesonconsulting.botns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mathesonconsulting.botns.domain.entities.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
	List<AuthorEntity> findByLastName(String lastName);
}
