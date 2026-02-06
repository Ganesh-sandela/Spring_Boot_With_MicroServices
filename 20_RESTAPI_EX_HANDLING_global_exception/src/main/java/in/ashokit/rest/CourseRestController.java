package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.SneakyThrows;
import in.ashokit.exception.COURSENOTFOUNDEXCEPTION;

@RestController

public class CourseRestController {

	@SneakyThrows
	@GetMapping("/course")
	public ResponseEntity<String> getcoursedetils(@RequestParam String name) {
		String msg=null;
		
		if ("java".equals(name)) {
			msg="java class start soon";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else if ("webtech".equals(name)) {
			msg="webtech starts soon...";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
		}
		else {
			{
				  throw new COURSENOTFOUNDEXCEPTION(name);
			}
		}
	}
	
}
