package br.com.alura.forum.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.forum.controller.repository.UserRepository;
import br.com.alura.forum.model.User;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> possibleUser = repository.findByEmail(email);
		
		return possibleUser.orElseThrow(()-> new UsernameNotFoundException("Não foi possível encontrar usuário com email: " + email));
	}

	public UserDetails loadUserById(Long id) {
		Optional<User> user = repository.findById(id);
		
		return user.orElseThrow(()-> new UsernameNotFoundException("Não foi possível encontrar o usuário com o id"));
	}

}
