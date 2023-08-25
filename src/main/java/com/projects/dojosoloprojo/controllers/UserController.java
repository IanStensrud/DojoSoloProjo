package com.projects.dojosoloprojo.controllers;


// import java.util.Random;
// import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//import com.projects.dojosoloprojo.models.Joke;
import com.projects.dojosoloprojo.models.LoginUser;
import com.projects.dojosoloprojo.models.User;
import com.projects.dojosoloprojo.services.ComedianService;
import com.projects.dojosoloprojo.services.JokeService;
import com.projects.dojosoloprojo.services.UserService;

//
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService uServ;

	@Autowired
	private JokeService jServ;
//
	@Autowired
	private ComedianService cServ;

	@GetMapping("/")
	public String caught() {
		return "redirect:/landing";
	}

	@GetMapping("/landing")
	public String begin(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());

		return "index.jsp";
		
	}

	@GetMapping("/dash")
	public String dash(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/";
		}
		
		
		model.addAttribute("user", uServ.getOne((Long) session.getAttribute("userId")));
		model.addAttribute("myJokes", jServ.getJokesByPoster(jServ.getJokePoster(userId)));
		model.addAttribute("jokes", jServ.getJokes());
		model.addAttribute("comedians", cServ.getComedians());
		return "dash.jsp";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.getAttribute("userId");
		return "redirect:/landing";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {

		User user = uServ.create(newUser, result);

		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		session.setAttribute("userId", user.getId());


		return "redirect:/dash";

	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = uServ.login(newLogin, result);

		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		session.setAttribute("userId", user.getId());
		return "redirect:/dash";
	}

}
