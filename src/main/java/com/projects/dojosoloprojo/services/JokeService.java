package com.projects.dojosoloprojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.projects.dojosoloprojo.models.Comedian;
// import com.projects.dojosoloprojo.models.Comedian;
import com.projects.dojosoloprojo.models.Joke;
import com.projects.dojosoloprojo.models.User;
import com.projects.dojosoloprojo.repositories.JokeRepository;


@Service
public class JokeService {

	@Autowired
	private JokeRepository jRepo;
	
	public JokeService(JokeRepository jRepo) {
		this.jRepo = jRepo;
	}

	public List<Joke> getMyJokes(Long id) {
		return jRepo.findAllById(id);
	}
	
	public User getJokePoster(Long id) {
		Optional<Joke> optJoke = jRepo.findById(id);
		if (optJoke.isPresent()) {
			Joke joke = optJoke.get();
			return joke.getPoster();
		}
		return null;
	}

	public List<Joke> getJokes() {
		return jRepo.findAll();
	}

	public List<Joke> getJokesByPoster(User poster) {
		
		return jRepo.findAllByPoster(poster);
	}
	
	public List<Joke> getAllByComedian(Comedian comedian) {
		
		return jRepo.findAllByComedian(comedian);
	}

	public Joke createJoke(Optional<Joke> joke, BindingResult result) {
		
		if (result.hasErrors()) {
			return null;
		}
		Joke freshJoke = joke.get();
		return jRepo.save(freshJoke);
	}

	public Joke updateJoke(Joke joke) {
		return jRepo.save(joke);
	}

	public void bomb(Joke joke) {
		jRepo.delete(joke);
	}

	public Joke getOne(Long id) {
		Optional<Joke> optJoke = jRepo.findById(id);
		if(optJoke.isPresent()) {
			return optJoke.get();
		} else {
			return null;
		}
	}
	
	
	
	public void addToFavorites(Joke joke, User user) {
		joke.getFavUsers().add(user);
		jRepo.save(joke);
		
	}
	
	public void removeFromFavorites(Joke joke, User user) {
		joke.getFavUsers().remove(user);
		jRepo.save(joke);
	}

//	public Joke getRandomJoke(Long id) {
//		Optional<Joke> optJoke = jRepo.findById(id);
//		if(optJoke.isPresent()) {
//			return optJoke.get();
//		} else {
//			return null;
//		}
//		public List<Joke>
//	}
}
