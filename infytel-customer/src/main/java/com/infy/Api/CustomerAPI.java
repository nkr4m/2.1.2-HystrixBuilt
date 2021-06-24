package com.infy.Api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.DTO.CustomerDTO;
import com.infy.DTO.PlanDTO;
import com.infy.Service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/")
@RibbonClient(name="custRibbon")
public class CustomerAPI {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	RestTemplate template;
	
//	@Autowired
//	DiscoveryClient client;
	@HystrixCommand(fallbackMethod = "getSpecificCustomerFallback")
	@GetMapping("/{phoneNo}")
	public ResponseEntity<CustomerDTO> getSpecificCustomer(@PathVariable Long phoneNo) throws Exception{
		System.out.println("=======In Profile========");
		CustomerDTO c = service.getSpecificCustomer(phoneNo);
		
//		List<ServiceInstance> friendInstances = client.getInstances("FRIENDFAMILYMS");
//		ServiceInstance friendInstance = friendInstances.get(1);
//		URI friendUri = friendInstance.getUri();
//		
		PlanDTO p = new RestTemplate().getForObject("http://localhost:8002/get/" + c.getCurrentPlan().getPlanId(), PlanDTO.class);
		c.setCurrentPlan(p);
		List<Long> list = template.getForObject("http://FRIENDFAMILYMS" + "/get/" + c.getPhoneNo(), List.class);
		c.setFriendFamily(list);
//		
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	public ResponseEntity<CustomerDTO> getSpecificCustomerFallback(Long phoneNo) throws Exception{
		System.out.println("========In Fallback=========");
		CustomerDTO c = new CustomerDTO();
		return new ResponseEntity<CustomerDTO>(c, HttpStatus.OK);
	}
	
}
