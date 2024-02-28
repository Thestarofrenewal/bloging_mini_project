package in.aman.service;

import in.aman.binding.LoginForm;
import in.aman.binding.UserRegistrationForm;

public interface UserService {
	
	public boolean userRegistration(UserRegistrationForm form);
	
	public boolean login(LoginForm form);

}
