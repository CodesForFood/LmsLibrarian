package com.smoothstack.lms.librarian.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.lms.librarian.entity.BookCopies;
import com.smoothstack.lms.librarian.entity.BookCopyId;

public interface BookCopiesDAO extends JpaRepository<BookCopies, BookCopyId>{

	
	@Query(value = "SELECT * FROM tbl_book_copies WHERE branchId = ?1", nativeQuery = true)
	public Optional<List<BookCopies>> findByBranchId(Integer branchId);
		
	@Query(value = "SELECT * FROM tbl_book_copies WHERE bookId = ?1", nativeQuery = true)
	public Optional<List<BookCopies>> findByBookId(Integer bookId);

	@Query(value = "SELECT * FROM tbl_book_copies WHERE bookId = ?1 AND branchId = ?2", nativeQuery = true)
	public Optional<BookCopies> findByBookAndBranchId(Integer bookId, Integer branchId);
	
	@Query(value = "UPDATE tbl_book_copies SET noOfCopies = ?3 WHERE bookid = ?1 AND branchId = ?2", nativeQuery = true)
	public BookCopies update(Integer bookId, Integer branchId, Integer noOfCopies);
	
}
