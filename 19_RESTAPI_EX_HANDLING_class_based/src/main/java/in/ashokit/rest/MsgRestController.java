package in.ashokit.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.pojo.MsgInfo;

@RestController
public class MsgRestController {
	
	
	@GetMapping("/getmsg")
	public String getmsg() {
		
		String s=null;
		s.length();  //=====> NullPointer Exception
	 String	msg="hello this is get msg";
		return msg;
	}
	
	
	@GetMapping("/greetmsg")
	public String greetmsg() {
		int a=10/0; //====> ArithematicPointer Exception
		String msg="good afternoon";
		return msg;
	}
	
	@GetMapping("/simplemsg")
	public String  simplemsg() {
		String msg="hello welcome to exception handling";
		return msg;	
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<MsgInfo> handleException(Exception e){
		
		String message = e.getMessage();
		MsgInfo msginfo= new MsgInfo();
		msginfo.setScode(12345);
		msginfo.setMsg(message);
		msginfo.setExdate(LocalDateTime.now());
		
		return new ResponseEntity<MsgInfo>(msginfo,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
