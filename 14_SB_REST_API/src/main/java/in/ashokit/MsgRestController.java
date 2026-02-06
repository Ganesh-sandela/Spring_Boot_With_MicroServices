package in.ashokit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/welcome")
	public String getwelcomemsg() {
		String msg="welcome to rest api...";
		 return msg;
	}
	
	@GetMapping("/greetmsg")
	public ResponseEntity<String> greetmsg() {
		
		String msg="hi good afternoon....";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	

}
