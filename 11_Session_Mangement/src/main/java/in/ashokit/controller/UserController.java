package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller

public class UserController {

	@GetMapping("/")
	public String index(Model model) {
		User uobj = new User();
		model.addAttribute("user", uobj);

		return "index";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest req, User user, Model model) {
		String email = user.getEmail();
		String password = user.getPassword();

		if (email.equals("gani@gmail.com") && password.equals("1234")) {
			// valid login
			HttpSession session = req.getSession(true);
			session.setAttribute("email", email);
			return "dashboard";
		} else {
			model.addAttribute("emsg", "invalid creditionls!!!!");

		}
		return "index";

	}
 
	@GetMapping("/personaldetails")
	@ResponseBody
	public String getpersonalDetails(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		String email = (String) session.getAttribute("email");
		// get user personal details
		return " Getting personal details personal-details of  " + email;

	}

	@GetMapping("/educationaldetails")
	@ResponseBody
	public String getEducationalDetails(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		String email = (String) session.getAttribute("email");
		// get user edu ediatls
		return " Getting educational details  of  " + email ;

	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest req, Model model) {
		User uobj = new User();
		model.addAttribute("user", uobj);

		HttpSession session = req.getSession();
		session.invalidate();

		return "index";
	}
}
