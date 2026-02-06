package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	@GetMapping("/demomsg")
	public String demomsg() {
		
		int a=10/0;
		return "tthis is demo msg";
	}
	

}
