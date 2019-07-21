package com.smoothstack.lms.librarian.entity;

import javax.persistence.*;


@Entity
@Table(name = "tbl_book_copies")
public class BookCopies {

	@EmbeddedId
	private BookCopyId bookCopyId;	
	
	@Column
	private Integer noOfCopies;
	

	public Integer getNoOfCopies() { return noOfCopies; } 
	public void setNoOfCopies(Integer noOfCopies) { this.noOfCopies = noOfCopies; }
	
	
	public BookCopyId getBookCopyId() {
		return bookCopyId;
	}
	public void setBookCopyId(BookCopyId bookCopyId) {
		this.bookCopyId = bookCopyId;
	}
	
}
