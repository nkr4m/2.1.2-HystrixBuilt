package com.infy.Repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.Entity.Plan;

public interface PlanRepository extends CrudRepository<Plan, Integer>{
	
}
