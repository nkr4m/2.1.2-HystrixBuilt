package com.infy.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DTO.FFDTO;
import com.infy.Service.FFService;

@RestController
@RequestMapping("/")
public class FFAPI {
	
	@Autowired
	FFService service;
	
	@GetMapping("get/{phoneNo}")
	public ResponseEntity<List<Long>> getList(@PathVariable	Long phoneNo) throws Exception{
		if(phoneNo == 9009009001L) {
			throw new RuntimeException();
		}
		List<Long> list = service.getListFF(phoneNo);
		System.out.println("----------------fetching-------------");
		return new ResponseEntity<List<Long>>(list , HttpStatus.OK);
	}
	
	@PostMapping("/{phoneNo}")
	public ResponseEntity<String> addFF(@PathVariable Long phoneNo, @RequestBody FFDTO ff){
		service.addFF(ff);
		String str = "Successfully added for contact Number" + ff.getPhoneNo();
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

}
