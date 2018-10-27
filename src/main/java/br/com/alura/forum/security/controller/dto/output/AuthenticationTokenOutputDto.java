package br.com.alura.forum.security.controller.dto.output;

public class AuthenticationTokenOutputDto {

	private String tokeType;
	private String token;
	
	
	
	public AuthenticationTokenOutputDto(String tokeType, String token) {
		super();
		this.tokeType = tokeType;
		this.token = token;
	}
	public String getTokeType() {
		return tokeType;
	}
	public void setTokeType(String tokeType) {
		this.tokeType = tokeType;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	 
	
}
