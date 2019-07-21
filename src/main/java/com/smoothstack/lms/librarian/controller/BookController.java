package com.smoothstack.lms.librarian.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.librarian.dao.BookDAO;
import com.smoothstack.lms.librarian.entity.Book;

@RestController
@RequestMapping("/librarian")
public class BookController {

	@Autowired
	private BookDAO bookDAO;
	
	
	@GetMapping(value ="/books")
	public List<Book> getAllBooks(@RequestParam(required = false, defaultValue = "100") int size) {
		Pageable limit = PageRequest.of(0,size);
		return bookDAO.findAll(limit).getContent();
	}	
	
	
	@GetMapping(value = "/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
		Optional<Book> book = bookDAO.findById(id);		
				
		return !book.isPresent() ? new ResponseEntity<Book>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<Book>(book.get(), HttpStatus.OK);						 
	}
}