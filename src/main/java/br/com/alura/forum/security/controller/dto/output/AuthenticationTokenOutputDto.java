package br.com.alura.forum.security.controller.dto.output;

import lombok.Getter;
import lombok.Setter;

public class AuthenticationTokenOutputDto {

	@Getter @Setter
	private String tokeType;
	
	@Getter @Setter
	private String token;
	
	
	public AuthenticationTokenOutputDto(String tokeType, String token) {
		super();
		this.tokeType = tokeType;
		this.token = token;
	}
	
}
