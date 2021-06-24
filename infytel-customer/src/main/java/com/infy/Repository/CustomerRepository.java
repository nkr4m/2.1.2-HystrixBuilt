package com.infy.Repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.Entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	

}
