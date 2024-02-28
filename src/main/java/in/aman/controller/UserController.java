package in.aman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.aman.binding.LoginForm;
import in.aman.binding.UserRegistrationForm;
import in.aman.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String getIndex() {

		return "index";
	}

	@GetMapping("/registration")
	public String registration(Model model) {

		model.addAttribute("user", new UserRegistrationForm());

		return "registration";
	}

	@PostMapping("/registration")
	public String registered(@ModelAttribute("user") UserRegistrationForm form, Model model) {

		boolean status = userService.userRegistration(form);

		if (status) {
			model.addAttribute("succMsg", "Regestered Successfully");

		} else {

			model.addAttribute("errMsg", "Email Already exist");
		}
		return "registration";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("user", new LoginForm());
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loggedIn(@ModelAttribute("user") LoginForm loginForm, Model model) {
		
		boolean status = userService.login(loginForm);
		
		if (status) {
			model.addAttribute("succMsg", "Successfully Logged in..!");
			return "redirect:/dashboard";

		} else {

			model.addAttribute("errMsg", "Invalid Email or Password");
		}
		
		return "login";
	}
}
