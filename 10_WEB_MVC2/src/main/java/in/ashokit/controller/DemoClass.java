package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class DemoClass {

	@GetMapping("/demo")
	
	public String demomsg(@RequestParam("name") String name) {//==>it both uses to send both clinet to server
		return name+" Good evening";                         //==>@RequestParm-->it can send key and value format
	}                                                        //==>@PathVariable-->it does not haev key and value format we s
	@GetMapping("/{name}/greet")                             //==>mention positiont
	public String greetname(@PathVariable("name") String name) {
		return "hi good night "+name;
	}

}
