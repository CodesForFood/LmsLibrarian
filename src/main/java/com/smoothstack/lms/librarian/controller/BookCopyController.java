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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.lms.librarian.dao.BookCopiesDAO;
import com.smoothstack.lms.librarian.entity.Book;
import com.smoothstack.lms.librarian.entity.BookCopies;
import com.smoothstack.lms.librarian.entity.LibraryBranch;

@RestController
@RequestMapping("/librarian")
public class BookCopyController {

	@Autowired
	private BookCopiesDAO bookCopyDAO;
	
	
	@GetMapping(value = "/bookcopies")
	public List<BookCopies> getAllBookCopies(@RequestParam(required = false, defaultValue = "100") int size) {
		Pageable limit = PageRequest.of(0,size);
		return bookCopyDAO.findAll(limit).getContent();
	}
	
	
	@GetMapping(value = "/bookcopy/book/{bookId}/branch/{branchId}")
	public ResponseEntity<BookCopies> getBookCopiesByBookAndBranch(@PathVariable Integer bookId, @PathVariable Integer branchId){
		if(bookId == null || branchId == null) {
			return new ResponseEntity<BookCopies>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<BookCopies> bookCopies = bookCopyDAO.findByBookAndBranchId(bookId, branchId);
		
		return bookCopies.isPresent() ? new ResponseEntity<BookCopies>(bookCopies.get(), HttpStatus.OK)
				: new ResponseEntity<BookCopies>(HttpStatus.NOT_FOUND);					
	}
	
	@GetMapping(value = "/bookcopy/book/{bookId}")
	public ResponseEntity<List<BookCopies>> getBookCopiesByBook(@PathVariable Integer bookId){
		if(bookId == null) {
			return new ResponseEntity<List<BookCopies>>(HttpStatus.BAD_REQUEST);
		}		
		
		Optional<List<BookCopies>> listBookCopies = bookCopyDAO.findByBookId(bookId); 
		
		return listBookCopies.isPresent() ? new ResponseEntity<List<BookCopies>>(listBookCopies.get(), HttpStatus.OK)
				: new ResponseEntity<List<BookCopies>>(HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping(value = "/bookcopy/branch/{branchId}")
	public ResponseEntity<List<BookCopies>> getBookCopiesOfBranch(@PathVariable Integer branchId){
		if(branchId == null) {
			return new ResponseEntity<List<BookCopies>>(HttpStatus.BAD_REQUEST);
		}		
		
		Optional<List<BookCopies>> listBookCopies = bookCopyDAO.findByBranchId(branchId); 
		
		return listBookCopies.isPresent() ? new ResponseEntity<List<BookCopies>>(listBookCopies.get(), HttpStatus.OK)
				: new ResponseEntity<List<BookCopies>>(HttpStatus.NOT_FOUND);		

	}
	
	@PostMapping(value = "/bookcopy")
	public BookCopies addBookCopies(@RequestBody BookCopies bookCopies) {		
		return bookCopyDAO.save(bookCopies);			
	}
	
	@PutMapping(value = "/bookcopy")
	public ResponseEntity<BookCopies> updateBookCopies(@RequestBody BookCopies bookCopies) {
		Book book = bookCopies.getBookCopyId().getBook();
		LibraryBranch branch  = bookCopies.getBookCopyId().getBranch();
		
		if(book == null || branch == null || bookCopies.getNoOfCopies() == null) {
			return new ResponseEntity<BookCopies>(HttpStatus.BAD_REQUEST);			
		}
		
		bookCopyDAO.update(book.getBookId(), branch.getBranchId(), bookCopies.getNoOfCopies());
		
		return new ResponseEntity<BookCopies>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

