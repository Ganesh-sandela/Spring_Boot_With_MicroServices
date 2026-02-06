package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.GET;

@RestController
public class WelcomRestController {
     
	@Autowired
	private Environment env;
	
	@GetMapping("/greet")
	public String greet() {
		String port = env.getProperty("server.port");
		
		return "Good Evening guys ("+port +")";
	}
}
