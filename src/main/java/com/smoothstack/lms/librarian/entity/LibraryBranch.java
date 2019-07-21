package com.smoothstack.lms.librarian.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_library_branch")
public class LibraryBranch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer branchId;
	
	@Column
	private String branchName;
	
	@Column
	private String branchAddress;

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	public LibraryBranch() {}
	
	public LibraryBranch(Integer id) {
		this.branchId = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchAddress == null) ? 0 : branchAddress.hashCode());
		result = prime * result + ((branchId == null) ? 0 : branchId.hashCode());
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryBranch other = (LibraryBranch) obj;
		if (branchAddress == null) {
			if (other.branchAddress != null)
				return false;
		} else if (!branchAddress.equals(other.branchAddress))
			return false;
		if (branchId == null) {
			if (other.branchId != null)
				return false;
		} else if (!branchId.equals(other.branchId))
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		return true;
	}
	
	
	
	
}
