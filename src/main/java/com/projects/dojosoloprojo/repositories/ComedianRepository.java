package com.projects.dojosoloprojo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projects.dojosoloprojo.models.Comedian;
// import com.projects.dojosoloprojo.models.Joke;


public interface ComedianRepository extends CrudRepository<Comedian, Long> {

	@Override
	List<Comedian> findAll();

	@Override
	Optional<Comedian> findById(Long id);
	
	Optional<Comedian> findByName(String name);
	

}
