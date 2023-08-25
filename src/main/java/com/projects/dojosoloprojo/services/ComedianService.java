package com.projects.dojosoloprojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.dojosoloprojo.models.Comedian;
import com.projects.dojosoloprojo.models.Joke;
import com.projects.dojosoloprojo.repositories.ComedianRepository;
import com.projects.dojosoloprojo.repositories.JokeRepository;
//import com.projects.dojosoloprojo.repositories.UserRepository;

@Service
public class ComedianService {

	@Autowired
	private ComedianRepository cRepo;
	
	@Autowired
	private JokeRepository jRepo;
	
//	@Autowired
//	private UserRepository userRepo;
	
	

	public ComedianService(ComedianRepository cRepo) {
		this.cRepo = cRepo;
	}

	public List<Comedian> getComedians(){
		return cRepo.findAll();
	}
	
	public List<Joke> getComediansJokes(Long id) {
		Optional<Comedian> optComedian = cRepo.findById(id);
		if(!optComedian.isPresent()) {
			return null;
		}
		Comedian comedian = optComedian.get();
		
		return jRepo.findAllByComedian(comedian);
	}

	public Comedian getComedian(Long id) {
		Optional<Comedian> thisGuy = cRepo.findById(id);
		if(thisGuy.isPresent()) {

			return thisGuy.get();
		}
		return null;
	}

	public Comedian introduce(Comedian comedian) {
		return cRepo.save(comedian);
	}

	public void hookem(Comedian comedian) {
		cRepo.delete(comedian);
	}



}
