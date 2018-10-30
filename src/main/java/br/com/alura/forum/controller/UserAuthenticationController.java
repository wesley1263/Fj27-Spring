package br.com.alura.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.security.controller.dto.input.LoginInputDto;
import br.com.alura.forum.security.controller.dto.output.AuthenticationTokenOutputDto;
import br.com.alura.forum.security.jwt.TokenManager;

@RestController
@RequestMapping("/api/auth")
public class UserAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticateManager;
	
	@Autowired
	private TokenManager tokenManager;

	public ResponseEntity<AuthenticationTokenOutputDto> authenticate(@RequestBody LoginInputDto loginInfo){
		
		try{
			UsernamePasswordAuthenticationToken authenticationToken = loginInfo.build();
			
			Authentication authentication = authenticateManager.authenticate(authenticationToken);
			
			String jwt = tokenManager.generateToken(authentication);
			
			AuthenticationTokenOutputDto tokenResponse = new AuthenticationTokenOutputDto("Bearer", jwt);
			
			return ResponseEntity.ok(tokenResponse);
			
		}catch(AuthenticationException ex){
			return ResponseEntity.badRequest().build();
		}
		
	}
}
