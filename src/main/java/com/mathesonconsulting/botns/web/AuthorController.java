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

import com.mathesonconsulting.botns.domain.dtos.Author;
import com.mathesonconsulting.botns.domain.entities.AuthorEntity;
import com.mathesonconsulting.botns.domain.mapping.DtoMapper;
import com.mathesonconsulting.botns.repository.AuthorRepository;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	@Resource(name = "mapper")
	private DtoMapper mapper;
	
	private AuthorRepository authorRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Author> findAll(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size) {
		List<Author> authors = null;
		
		Pageable pageable = null;
		
		if (page != null && size != null) {
			pageable = new PageRequest(page, size);
		} else {
			pageable = new PageRequest(0, Integer.MAX_VALUE);
		}
		
		Page<AuthorEntity> authorEntities = authorRepository.findAll(pageable);
		
		if (authorEntities != null) {
			authors = mapper.mapAsList(authorEntities.getContent(), Author.class);
		}
		
		return authors;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Author findOne(@PathVariable Long id) {
		AuthorEntity authorEntity = authorRepository.findOne(id);
		
		return mapper.map(authorEntity, Author.class);
	}
	
	@Resource(name = "authorRepository")
	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
}
