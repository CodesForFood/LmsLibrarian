package com.smoothstack.lms.librarian.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.librarian.entity.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
