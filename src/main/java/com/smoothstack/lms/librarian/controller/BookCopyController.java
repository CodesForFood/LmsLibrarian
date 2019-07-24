package com.smoothstack.lms.librarian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.librarian.entity.BookCopies;
import com.smoothstack.lms.librarian.service.BookCopyService;

@RestController
@RequestMapping("/librarian")
public class BookCopyController {

	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private BookCopyService copyService;
	
	@GetMapping(value = "/number-of-copies", produces = { XML, JSON })
	public List<BookCopies> getAllBookCopies(@RequestParam(required = false, defaultValue = "100") int size) {
		return copyService.getAllBookCopies(size);
	}
	
	@GetMapping(value = "/number-of-copies/ofBook/{bookId}/inBranch/{branchId}", produces = { XML, JSON })
	public ResponseEntity<BookCopies> getBookCopiesByBookAndBranch(@PathVariable Integer bookId, @PathVariable Integer branchId){
		return copyService.getBookCopiesByBookAndBranch(bookId, branchId);				
	}
	
	@GetMapping(value = "/number-of-copies/ofBook/{bookId}", produces = { XML, JSON })
	public ResponseEntity<List<BookCopies>> getBookCopiesByBook(@PathVariable Integer bookId){
		if(bookId == null) {
			return new ResponseEntity<List<BookCopies>>(HttpStatus.BAD_REQUEST);
		}		
		return copyService.getBookCopiesByBook(bookId);	
	}
	
	@GetMapping(value = "/number-of-copies/inBranch/{branchId}", produces = { XML, JSON })
	public ResponseEntity<List<BookCopies>> getBookCopiesOfBranch(@PathVariable Integer branchId){
		if(branchId == null) {
			return new ResponseEntity<List<BookCopies>>(HttpStatus.BAD_REQUEST);
		}				
		return copyService.getBookCopiesOfBranch(branchId);	
	}	

	@PostMapping(value = "/number-of-copies", produces = { XML, JSON }, consumes = { XML, JSON })
	public BookCopies addBookCopies(@RequestBody BookCopies bookCopies) {		
		return copyService.addBookCopies(bookCopies);
	}	

	@PutMapping(value = "/number-of-copies", produces = { XML, JSON }, consumes = { XML, JSON})
	public ResponseEntity<BookCopies> updateBookCopies(@RequestBody BookCopies bookCopies) {
		return copyService.updateBookCopies(bookCopies);
	}	
}

