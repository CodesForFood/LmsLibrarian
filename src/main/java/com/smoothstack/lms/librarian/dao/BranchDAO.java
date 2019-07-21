package com.smoothstack.lms.librarian.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.lms.librarian.entity.LibraryBranch;

public interface BranchDAO extends JpaRepository<LibraryBranch, Integer> {

}
