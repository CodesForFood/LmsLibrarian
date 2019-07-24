package com.smoothstack.lms.librarian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.librarian.entity.Book;
import com.smoothstack.lms.librarian.service.BookService;

@RestController
@RequestMapping("/librarian")
public class BookController {
	
	private final String XML = "application/xml";
	private final String JSON = "application/json";

	@Autowired
	private BookService bookService;
	
	
	@GetMapping(value ="/books", produces = { XML, JSON })
	public List<Book> getAllBooks(@RequestParam(required = false, defaultValue = "100") int size) {		
		return bookService.getAllBooks(size);
	}	
	
	
	@GetMapping(value = "/book/{id}", produces = { XML, JSON })
	public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
		return bookService.getBookById(id);						 
	}
}