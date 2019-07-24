package com.smoothstack.lms.librarian.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smoothstack.lms.librarian.dao.BranchDAO;
import com.smoothstack.lms.librarian.entity.LibraryBranch;

@Service
public class BranchService {

	
	@Autowired
	private BranchDAO branchDAO;	

	public List<LibraryBranch> getAllBranches(int size) {
		Pageable limit = PageRequest.of(0,size);
		return branchDAO.findAll(limit).getContent();
	}	

	public ResponseEntity<LibraryBranch> getBranchById(Integer id) {
		Optional<LibraryBranch> branch = branchDAO.findById(id);		
				
		return !branch.isPresent() ? new ResponseEntity<LibraryBranch>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<LibraryBranch>(branch.get(), HttpStatus.OK);						 
	}
	
	public LibraryBranch  updateBranch(LibraryBranch branch) {				
		return branchDAO.save(branch);
	}	
	
}
