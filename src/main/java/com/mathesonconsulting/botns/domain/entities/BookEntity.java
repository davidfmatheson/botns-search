package com.mathesonconsulting.botns.domain.entities;

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
public class BookEntity {
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
	private List<AuthorEntity> authors;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_narrator",
			joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
	private List<AuthorEntity> narrators;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_editor",
			joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")})
	private List<AuthorEntity> editors;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
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

	public List<AuthorEntity> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AuthorEntity> authors) {
		this.authors = authors;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<AuthorEntity> getNarrators() {
		return narrators;
	}

	public void setNarrators(List<AuthorEntity> narrators) {
		this.narrators = narrators;
	}

	public List<AuthorEntity> getEditors() {
		return editors;
	}

	public void setEditors(List<AuthorEntity> editors) {
		this.editors = editors;
	}
}
