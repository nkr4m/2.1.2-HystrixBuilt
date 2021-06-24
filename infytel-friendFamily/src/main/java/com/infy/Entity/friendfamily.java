package com.infy.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class friendfamily {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long phoneNo;
	private Long friendAndFamily;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Long getFriendAndFamily() {
		return friendAndFamily;
	}
	public void setFriendAndFamily(Long friendAndFamily) {
		this.friendAndFamily = friendAndFamily;
	}
	
	
	
	

}
