package com.infy.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.Entity.friendfamily;

public interface FFRepository extends CrudRepository<friendfamily, Integer>{
	
	List<friendfamily> findByPhoneNo(Long PhoneNo);
}
