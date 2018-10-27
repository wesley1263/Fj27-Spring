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
	private UserRepository respository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> possibleUser = respository.findByEmail(email);
		
		return possibleUser.orElseThrow(()-> new UsernameNotFoundException("Não foi possível encontrar usuário com email: " + email));
	}

}
