package com.mathesonconsulting.botns.domain.mapping;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import org.springframework.stereotype.Component;

import com.mathesonconsulting.botns.domain.dtos.Author;
import com.mathesonconsulting.botns.domain.dtos.Book;
import com.mathesonconsulting.botns.domain.dtos.Category;
import com.mathesonconsulting.botns.domain.entities.AuthorEntity;
import com.mathesonconsulting.botns.domain.entities.BookEntity;
import com.mathesonconsulting.botns.domain.entities.CategoryEntity;

@Component("mapper")
public class DtoMapper extends ConfigurableMapper {
	@Override
	protected void configure(MapperFactory mapperFactory) {
		mapperFactory.classMap(AuthorEntity.class, Author.class)
			.byDefault()
			.register();
		mapperFactory.classMap(BookEntity.class, Book.class)
			.byDefault()
			.register();
		mapperFactory.classMap(CategoryEntity.class, Category.class)
			.byDefault()
			.register();
	}
}
