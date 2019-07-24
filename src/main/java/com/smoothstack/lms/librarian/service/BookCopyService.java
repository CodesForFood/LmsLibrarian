package com.smoothstack.lms.librarian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.lms.librarian.dao.BookCopiesDAO;
import com.smoothstack.lms.librarian.entity.Book;
import com.smoothstack.lms.librarian.entity.BookCopies;
import com.smoothstack.lms.librarian.entity.LibraryBranch;

@Service
public class BookCopyService {

	@Autowired
	private BookCopiesDAO copyDAO;
	
	public List<BookCopies> getAllBookCopies(int size) {
		Pageable limit = PageRequest.of(0,size);
		return copyDAO.findAll(limit).getContent();
	}	
	
	public ResponseEntity<BookCopies> getBookCopiesByBookAndBranch(Integer bookId, Integer branchId){
		if(bookId == null || branchId == null) {
			return new ResponseEntity<BookCopies>(HttpStatus.BAD_REQUEST);
		}
		
		Optional<BookCopies> bookCopies = copyDAO.findByBookAndBranchId(bookId, branchId);
		
		return bookCopies.isPresent() ? new ResponseEntity<BookCopies>(bookCopies.get(), HttpStatus.OK)
				: new ResponseEntity<BookCopies>(HttpStatus.NOT_FOUND);					
	}	
	
	public ResponseEntity<List<BookCopies>> getBookCopiesByBook(Integer bookId){					
		Optional<List<BookCopies>> listBookCopies = copyDAO.findByBookId(bookId); 
		
		return listBookCopies.isPresent() ? new ResponseEntity<List<BookCopies>>(listBookCopies.get(), HttpStatus.OK)
				: new ResponseEntity<List<BookCopies>>(HttpStatus.NOT_FOUND);		
	}	
	
	public ResponseEntity<List<BookCopies>> getBookCopiesOfBranch(Integer branchId){				
		Optional<List<BookCopies>> listBookCopies = copyDAO.findByBranchId(branchId); 
		
		return listBookCopies.isPresent() ? new ResponseEntity<List<BookCopies>>(listBookCopies.get(), HttpStatus.OK)
				: new ResponseEntity<List<BookCopies>>(HttpStatus.NOT_FOUND);
	}	
	
	@Transactional
	public BookCopies addBookCopies(BookCopies bookCopies) {		
		return copyDAO.save(bookCopies);			
	}	
	
	@Transactional
	public ResponseEntity<BookCopies> updateBookCopies(BookCopies bookCopies) {
		Book book = bookCopies.getBookCopyId().getBook();
		LibraryBranch branch  = bookCopies.getBookCopyId().getBranch();
		
		if(book == null || branch == null || bookCopies.getNoOfCopies() == null) {
			return new ResponseEntity<BookCopies>(HttpStatus.BAD_REQUEST);			
		}
		
		copyDAO.update(book.getBookId(), branch.getBranchId(), bookCopies.getNoOfCopies());
		
		return new ResponseEntity<BookCopies>(HttpStatus.OK);
	}	
	
	
}
