package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class DataRestController {
	
	@GetMapping("/data")
	@CircuitBreaker(fallbackMethod = "getDataFromDB", name="default")
	public String getDataFromReddies() {
		System.out.println("***********reddis() method called,,,,,,,,,,,");
		int i=10/0;
	   return "fetching from reddies";
	}
	
	public String getDataFromDB( Throwable t) {
		System.out.println("***********DB() method called,,,,,,,,,,,");
	   return "fetching from DB";
	}
	
	

}
