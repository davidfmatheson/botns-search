package com.mathesonconsulting.botns.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_author",
			joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
	private List<Author> authors;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_narrator",
			joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
	private List<Author> narrators;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_editor",
			joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
	private List<Author> editors;

	@ManyToOne
	@JoinColumn(name = "category_id")
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
