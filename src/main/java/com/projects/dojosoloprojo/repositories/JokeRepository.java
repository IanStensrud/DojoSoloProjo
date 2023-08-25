package com.projects.dojosoloprojo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projects.dojosoloprojo.models.Comedian;
import com.projects.dojosoloprojo.models.Joke;
import com.projects.dojosoloprojo.models.User;

public interface JokeRepository extends CrudRepository<Joke, Long> {

	@Override
	List<Joke> findAll();

	List<Joke> findAllById(Long id);

	@Override
	Optional<Joke> findById(Long id);

	List<Joke> findAllByPoster(User poster);
	
	List<Joke> findAllByComedian(Comedian comedian);
	

}
