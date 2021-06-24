package com.infy.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.DTO.CustomerDTO;
import com.infy.DTO.PlanDTO;
import com.infy.Entity.Customer;
import com.infy.Repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository repo;
	
	public CustomerDTO getSpecificCustomer(Long PhoneNo) {
		Optional<Customer> op = repo.findById(PhoneNo);
		
		Customer cust = op.get();
		
		CustomerDTO c = new CustomerDTO();
		c.setAddress(cust.getAddress());
		c.setAge(cust.getAge());
		c.setGender(cust.getGender());
		c.setName(cust.getName());
		c.setPassword(cust.getPassword());
		c.setPhoneNo(cust.getPhoneNo());
		
		PlanDTO p = new PlanDTO();
		p.setPlanId(cust.getPlanId());
		c.setCurrentPlan(p);
		
		return c;
	}

}
