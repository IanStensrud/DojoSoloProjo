package com.projects.dojosoloprojo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projects.dojosoloprojo.models.User;


public interface UserRepository extends CrudRepository<User, Long> {

	@Override
	List<User> findAll();

	Optional<User> findByEmail(String email);

	@Override
	Optional<User> findById(Long id);
	
	
}
