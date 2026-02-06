package in.ashokit.controller;
import in.ashokit.service.UserServiceImpl;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.entity.User;
import in.ashokit.service.UserService;

@Controller
public class UserController {

	@Autowired
  private UserService userservice;
	
	//open user form
	@GetMapping("/")
	public String loadForm(Model model) {
		User uobj= new User();
		model.addAttribute("user", uobj);
		//logic
		return"index";
	}
	
	//handle for submit
	@PostMapping("/user")
	public String handleSubmit( @Valid User user,
			                      BindingResult result,
			                    Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		Boolean saved = userservice.save(user);
		if (saved) {
			model.addAttribute("smsg","succesfully done");
		}
		else {
			model.addAttribute("emsg", "Error has occured");
		}
		return "index";
	}
	//handle view users  page display
	@GetMapping("/users")
	public String getusers(Model model) {
	  List<User> list = userservice.getall();
	  model.addAttribute("list",list);
		return"users";
	}
	@GetMapping("/delete")
	public String deleteuser(@RequestParam Integer id) {
		userservice.delete(id);		
		return "redirect:/users";
	}
	@GetMapping("/edit")
	public String edituser(@RequestParam Integer id, Model model) {
		User user = userservice.get(id);
		User u= new User();
		u.setName(user.getName());
		u.setId(user.getId());
		u.setEmail(user.getEmail());
		u.setPhno(user.getPhno());
		model.addAttribute("user",u);
		return "index";
	}

}
