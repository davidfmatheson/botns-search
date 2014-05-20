package com.mathesonconsulting.botns.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mathesonconsulting.botns.entity.Book;
import com.mathesonconsulting.botns.repository.BookRepository;

@Controller
@RequestMapping(value = "/books")
public class BookController {
	private BookRepository bookRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Page<Book> findAll(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "sort", required = false) String sort) {
		
		Pageable pageable = null;
		
		if (page != null && limit != null) {
			pageable = new PageRequest(page - 1, limit);
		} else {
			pageable = new PageRequest(0, Integer.MAX_VALUE);
		}
		
		return bookRepository.findAll(pageable);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Book findOne(@PathVariable Long id) {
		return bookRepository.findOne(id);
	}
	
	@RequestMapping(value = "/search/{title}", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> findByTitle(@PathVariable String title) {
		return bookRepository.findByTitle(title);
	}
	
	@Resource(name = "bookRepository")
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
}
