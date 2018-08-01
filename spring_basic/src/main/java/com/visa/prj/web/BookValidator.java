package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Book;

@Component
public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Book.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "book.id.required", "Book ID is required!!!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "book.title.required", "Title is required!!!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "book.price.required", "Price required!!!");
		Book book = (Book) obj;
		if(book.getPrice() < 0) {
			errors.rejectValue("price", "invalid.price", "Price should be greater than ZERO :-(");
		}
	}

}
