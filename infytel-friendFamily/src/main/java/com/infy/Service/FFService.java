package com.infy.Service;

import java.util.List;

import com.infy.DTO.FFDTO;
import com.infy.Entity.friendfamily;

public interface FFService {
	
	public List<Long> getListFF(Long PhoneNo);
	
	public void addFF(FFDTO ff);

}
