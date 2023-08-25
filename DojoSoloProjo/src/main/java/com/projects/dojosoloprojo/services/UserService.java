package com.projects.dojosoloprojo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.projects.dojosoloprojo.models.Joke;
import com.projects.dojosoloprojo.models.LoginUser;
import com.projects.dojosoloprojo.models.User;
import com.projects.dojosoloprojo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;

	}
	
	public void addFav(User user, Joke joke) {
		user.getFavs().add(joke);
		userRepo.save(user);
	}
	
	public void removeFav(User user, Joke joke) {
		user.getFavs().remove(joke);
		userRepo.save(user);
	}

	public User create(User user, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(user.getEmail());
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email already in use.");
		}

		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords must match.");
		}

		if(result.hasErrors()) {
			return null;
		}

		String hashword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashword);
		return userRepo.save(user);

	}
	
	

	public User login(LoginUser login, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(login.getConfirmEmail());

		if(!optionalUser.isPresent()) {
			result.rejectValue("confirmEmail", "Matches", "Email incorrect.");
			return null;
		}

		User user = optionalUser.get();

		if(!BCrypt.checkpw(login.getConfirmPassword(), user.getPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Password incorrect.");
		}

		if(result.hasErrors()) {
			return null;
		}

		return user;

	}

	public User getOne(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);

		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}

		return null;

	}
}
