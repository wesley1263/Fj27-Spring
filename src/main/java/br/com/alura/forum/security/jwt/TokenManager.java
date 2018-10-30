package br.com.alura.forum.security.jwt;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import br.com.alura.forum.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenManager {

	private String secret;
	
	private Long expirationInMillis;
	
	public String generateToken(Authentication authenticate){
		User user = (User) authenticate.getPrincipal();
		
		final Date now = new Date();
		final Date expiration = new Date(now.getTime() + this.expirationInMillis);
		
		return Jwts.builder()
			   .setIssuer("Alura Forum API")
			   .setSubject(Long.toString(user.getId()))
			   .setIssuedAt(now)
			   .setExpiration(expiration)
			   .signWith(SignatureAlgorithm.HS256, this.secret)
			   .compact();
	}
	
}
