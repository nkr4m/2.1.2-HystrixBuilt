package com.infy.DTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
	
	private Long PhoneNo;
	private String name;
	private Integer age;
	private String gender;
	private String address;
//	private Integer planId;
	private String password;
	
	private PlanDTO currentPlan;
	private List<Long> friendFamily = new ArrayList<>();
	
	
	public Long getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public PlanDTO getCurrentPlan() {
		return currentPlan;
	}
	public void setCurrentPlan(PlanDTO currentPlan) {
		this.currentPlan = currentPlan;
	}
	public List<Long> getFriendFamily() {
		return friendFamily;
	}
	public void setFriendFamily(List<Long> friendFamily) {
		this.friendFamily = friendFamily;
	}
	
	
	
	
	

}
