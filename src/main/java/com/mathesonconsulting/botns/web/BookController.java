package com.mathesonconsulting.botns.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mathesonconsulting.botns.domain.dtos.Book;
import com.mathesonconsulting.botns.domain.entities.BookEntity;
import com.mathesonconsulting.botns.domain.mapping.DtoMapper;
import com.mathesonconsulting.botns.repository.BookRepository;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	@Resource(name = "mapper")
	private DtoMapper mapper;
	
	private BookRepository bookRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Book> findAll(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		List<Book> books = null;
		
		Pageable pageable = null;
		
		if (page != null && size != null) {
			pageable = new PageRequest(page, size);
		} else {
			pageable = new PageRequest(0, Integer.MAX_VALUE);
		}
		
		Page<BookEntity> bookEntities = bookRepository.findAll(pageable);
		
		if (bookEntities != null) {
			books = mapper.mapAsList(bookEntities.getContent(), Book.class);
		}
		
		return books;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> findByTitle(@RequestParam(value = "title", required = true) String title) {
		List<BookEntity> bookEntities = bookRepository.findByTitle(title);
		return mapper.mapAsList(bookEntities, Book.class);
	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public Long count() {
		return bookRepository.count();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Book findOne(@PathVariable Long id) {
		BookEntity bookEntity = bookRepository.findOne(id);
		return mapper.map(bookEntity, Book.class);
	}
	
	@Resource(name = "bookRepository")
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
}
