package com.infy.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.DTO.FFDTO;
import com.infy.Entity.friendfamily;
import com.infy.Repository.FFRepository;

@Service
@Transactional
public class FFServiceImpl implements FFService{
	
	@Autowired
	FFRepository repo;
	
	public List<Long> getListFF(Long PhoneNo){
		List<friendfamily> iter = repo.findByPhoneNo(PhoneNo);
		List<Long> list = new ArrayList();
		
		for(friendfamily f : iter) {
			list.add(f.getFriendAndFamily());
		}
		
		return list;
	}
	
	public void addFF(FFDTO ff) {
		
//		System.out.println(ff.getFriendAndFamily() + " " +  ff.getPhoneNo());
		friendfamily f = new friendfamily();
		f.setFriendAndFamily(ff.getFriendAndFamily());
		f.setPhoneNo(ff.getPhoneNo());
//		System.out.println(f.getPhoneNo());
		repo.save(f);
	}
}
