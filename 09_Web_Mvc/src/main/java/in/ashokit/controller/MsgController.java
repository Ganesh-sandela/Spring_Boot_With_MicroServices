package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MsgController {
    @GetMapping("/greet")
	public String greetmsg(Model model) {
		model.addAttribute("msg","Good Morning to all");
		return "index";
	}
	
	@GetMapping("/welcome")
	public ModelAndView greetmsg() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("msg","welcome to spring web mvc");
		mv.setViewName("index");
		return mv;
	}
}
