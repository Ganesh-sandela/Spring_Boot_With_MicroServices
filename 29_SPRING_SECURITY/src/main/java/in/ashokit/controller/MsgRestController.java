package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	
	@GetMapping("/contact")
	public String getcnct() {
		return "Call +91 345678956789";
	}
	
	@GetMapping("/welcome")
	public String getwel() {
		return "welcome to spring security";
	}
	
	
	@GetMapping("/greet")
	public String getgret() {
		return "good afternoon....";
	}
}
