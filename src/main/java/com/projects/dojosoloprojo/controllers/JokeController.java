package com.projects.dojosoloprojo.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projects.dojosoloprojo.models.Comedian;
import com.projects.dojosoloprojo.models.Joke;
import com.projects.dojosoloprojo.models.User;
import com.projects.dojosoloprojo.services.ComedianService;
import com.projects.dojosoloprojo.services.JokeService;
import com.projects.dojosoloprojo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class JokeController {

	@Autowired
	private UserService uServ;

	@Autowired
	private JokeService jServ;

	@Autowired
	private ComedianService cServ;


	@GetMapping("/joke/show/{id}")
	public String show(@PathVariable("id")Long id, Model model, HttpSession session) {

		Joke joke = jServ.getOne(id);
		User user = uServ.getOne((Long)session.getAttribute("userId"));
		List<Joke> favs = user.getFavs();
		List<User> favUsers = joke.getFavUsers();
		model.addAttribute("joke", joke);
		model.addAttribute("favs", favs);
		model.addAttribute("favUsers", favUsers);
		return "show.jsp";
	}
	

	@GetMapping("/jokes/jokratory")
	public String jokratory(@ModelAttribute("newJoke") Joke joke, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

		if(userId==null) {
			return "redirect:/";
		}

		model.addAttribute("user", uServ.getOne(userId));
		model.addAttribute("comedians", cServ.getComedians());
		return "jokratory.jsp";
	}


	@GetMapping("/jokes/rewrite/{id}")
	public String rewrite(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

		if(userId==null) {
			return "redirect:/joke/show/{id}";
		}
		model.addAttribute("user", uServ.getOne(userId));
		model.addAttribute("comedians", cServ.getComedians());
		model.addAttribute("joke", jServ.getOne(id));
		return "rewrite.jsp";
	}

	@PostMapping("/joke/update/{id}")
	public String update(@PathVariable("id")Long id, Model model, @Valid @ModelAttribute("joke") Joke freshJoke, BindingResult results, HttpSession session) {
		if(results.hasErrors()) {
			model.addAttribute("user", uServ.getOne((Long)session.getAttribute("userId")));
			model.addAttribute("comedians", cServ.getComedians());
			model.addAttribute("joke", jServ.getOne(id));
			return "rewrite.jsp";
		} else {
			jServ.updateJoke(freshJoke);
			return "redirect:/dash";
		}
	}


	@PostMapping("/joke/fav/{jokeId}")
	public String addToFavs(@PathVariable("jokeId")Long id, Model model, HttpSession session) {
		User user = uServ.getOne((Long) session.getAttribute("userId"));
		Joke joke = jServ.getOne(id);
		
		
		uServ.addFav(user, joke);
		return "redirect:/joke/show/{jokeId}";
	}
	
	@PostMapping("/joke/unfav/{jokeId}")
	public String removeFromFavs(@PathVariable("jokeId")Long id, Model model, HttpSession session) {
		User user = uServ.getOne((Long) session.getAttribute("userId"));
		Joke joke = jServ.getOne(id);
			
		uServ.removeFav(user, joke);
		return "redirect:/joke/show/{jokeId}";
	}
	@PostMapping("/jokes/write")
	public String write(@Valid @ModelAttribute("newJoke") Optional<Joke> newJoke, BindingResult result, @ModelAttribute("owner") Comedian comedian, @ModelAttribute("poster")User user, Model model, HttpSession session) {
		
		Joke freshJoke = jServ.createJoke(newJoke, result);
		
		if(result.hasErrors()) {
			model.addAttribute("user", uServ.getOne((Long) session.getAttribute("userId")));
			model.addAttribute("newJoke", new Joke());
			model.addAttribute("comedians", cServ.getComedians());
			return "jokratory.jsp";
		}
		freshJoke.setPoster(uServ.getOne((Long) session.getAttribute("userId")));

		
		
		return "redirect:/dash";
	}

	@GetMapping("/jokes/bomb/{id}")
	public void bomb(Long id) {
		jServ.bomb(jServ.getOne(id));
	}
}
