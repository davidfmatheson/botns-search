package com.mathesonconsulting.botns.web;

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

import com.mathesonconsulting.botns.domain.entities.Author;
import com.mathesonconsulting.botns.repository.AuthorRepository;

@Controller
@RequestMapping(value = "/authors")
public class AuthorController {
	private AuthorRepository authorRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Page<Author> findAll(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "sort", required = false) String sort) {
		Pageable pageable = null;
		
		if (page != null && limit != null) {
			pageable = new PageRequest(page - 1, limit);
		} else {
			pageable = new PageRequest(0, Integer.MAX_VALUE);
		}
		
		return authorRepository.findAll(pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Author findOne(@PathVariable Long id) {
		return authorRepository.findOne(id);
	}
	
	@Resource(name = "authorRepository")
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
}
