package br.com.alura.forum.controller.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.alura.forum.model.User;

public interface UserRepository extends Repository<User, Long> {
	
	Optional<User> findByEmail(String email);

}