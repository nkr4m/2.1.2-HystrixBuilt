package com.infy.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.DTO.PlanDTO;
import com.infy.Entity.Plan;
import com.infy.Repository.PlanRepository;

@Service
@Transactional
public class PlanServiceImpl implements PlanService{
	
	
	@Autowired
	PlanRepository repo;
	
	public PlanDTO getSpecificPlan(Integer planId) {
		
		Optional<Plan> op = repo.findById(planId);
		Plan plan = op.get();
		
		PlanDTO p1 = new PlanDTO();
		
		p1.setPlanId(plan.getPlanId());
		p1.setNationalRate(plan.getNationalRate());
		p1.setLocalRate(plan.getLocalRate());
		p1.setPlanName(plan.getPlanName());
		
		return p1;
		
	}
}
