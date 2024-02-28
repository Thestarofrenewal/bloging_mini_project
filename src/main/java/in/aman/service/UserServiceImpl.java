package in.aman.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.aman.binding.LoginForm;
import in.aman.binding.UserRegistrationForm;
import in.aman.entity.UserEntity;
import in.aman.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public boolean userRegistration(UserRegistrationForm form) {
		
		UserEntity status = userRepo.findByEmail(form.getEmail());
		
		if (status != null) {
			
			return false;			
		}
		
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(form, entity);
		
		entity.setFname(form.getFName());
		entity.setLname(form.getLName());
		entity.setEmail(form.getEmail());
		entity.setPwd(form.getPassword());

		userRepo.save(entity);
		
		return true;
	}

	@Override
	public boolean login(LoginForm form) {
		
	UserEntity status = userRepo.findByEmailAndPwd(form.getEmail(), form.getPassword());
		
		if (status != null) {
						
			return true;			
		}
		return false;
	}

}
