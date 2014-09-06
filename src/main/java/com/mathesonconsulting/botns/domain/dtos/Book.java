package com.mathesonconsulting.botns.domain.dtos;

import java.util.List;

public class Book {
	private Long id;
	
	private String title;
	
	private List<Author> authors;

	private List<Author> narrators;

	private List<Author> editors;

	private Category category;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Author> getNarrators() {
		return narrators;
	}

	public void setNarrators(List<Author> narrators) {
		this.narrators = narrators;
	}

	public List<Author> getEditors() {
		return editors;
	}

	public void setEditors(List<Author> editors) {
		this.editors = editors;
	}
}
