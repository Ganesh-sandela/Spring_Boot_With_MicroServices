package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.feign.GreetFeigenClient;


@RestController
public class WelcomeController {
	
	@Autowired
	private GreetFeigenClient gfc;

	@GetMapping("/welcome")
	public String getmsg() {
		String msg="welcome to the server";
		String body = gfc.invokedmethod();
		return msg +body;
		
	}
	
}
