package com.smoothstack.lms.librarian.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisherId")
	private Integer pubId;
	
	@Column(name = "publisherName")
	private String pubName;
	
	@Column(name = "publisherAddress")
	private String pubAddress;
	
	@Column(name = "publisherPhone")
	private String pubPhone;
	

	public Integer getPubId() {
		return pubId;
	}

	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public String getPubAddress() {
		return pubAddress;
	}

	public void setPubAddress(String pubAddress) {
		this.pubAddress = pubAddress;
	}

	public String getPubPhone() {
		return pubPhone;
	}

	public void setPubPhone(String pubPhone) {
		this.pubPhone = pubPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pubAddress == null) ? 0 : pubAddress.hashCode());
		result = prime * result + ((pubId == null) ? 0 : pubId.hashCode());
		result = prime * result + ((pubName == null) ? 0 : pubName.hashCode());
		result = prime * result + ((pubPhone == null) ? 0 : pubPhone.hashCode());
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
		Publisher other = (Publisher) obj;
		if (pubAddress == null) {
			if (other.pubAddress != null)
				return false;
		} else if (!pubAddress.equals(other.pubAddress))
			return false;
		if (pubId == null) {
			if (other.pubId != null)
				return false;
		} else if (!pubId.equals(other.pubId))
			return false;
		if (pubName == null) {
			if (other.pubName != null)
				return false;
		} else if (!pubName.equals(other.pubName))
			return false;
		if (pubPhone == null) {
			if (other.pubPhone != null)
				return false;
		} else if (!pubPhone.equals(other.pubPhone))
			return false;
		return true;
	}
	
	
	
}
