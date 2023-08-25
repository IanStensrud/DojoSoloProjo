package com.projects.dojosoloprojo.controllers;

import java.util.List;

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
public class ComedianController {

	@Autowired
	private UserService uServ;

	@Autowired
	private JokeService jServ;

	@Autowired
	private ComedianService cServ;

	@GetMapping("/killtony")
	public String introduce(@ModelAttribute("newComedian") Comedian comedian, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");

		if(userId==null) {
			return "redirect:/";
		}

		model.addAttribute("user", uServ.getOne(userId));
		return "killtony.jsp";

	}

	@GetMapping("/comedians/{id}")
	public String comedianShow(@PathVariable("id")Long id, Model model, HttpSession session) {

		Comedian comedian = cServ.getComedian(id);
		List<Joke> jokes = jServ.getAllByComedian(comedian);
		User user = uServ.getOne((Long)session.getAttribute("userId"));


		model.addAttribute("comedian", comedian);
		model.addAttribute("jokes", jokes);
		model.addAttribute("user", user);
		return "comedianShow.jsp";
	}

	@PostMapping("/introduce")
	public String introduce(@Valid @ModelAttribute("newComedian") Comedian newComedian, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newComedian", new Comedian());
			return "redirect:/killtony";
		}
		cServ.introduce(newComedian);
		return "redirect:/dash";
	}



}
