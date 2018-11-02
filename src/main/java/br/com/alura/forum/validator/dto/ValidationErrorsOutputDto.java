package br.com.alura.forum.validator.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorsOutputDto {
	
 	private List<String> globalErrorMessages = new ArrayList<>();
 	private List<FieldErrorOutputDto> fieldErros = new ArrayList<>();
 	
 	
 	public void addError(String message){
 		globalErrorMessages.add(message);
 	}
 	
 	public void addFieldError(String field, String message){
 		FieldErrorOutputDto fieldError = new FieldErrorOutputDto(field, message);
 		fieldErros.add(fieldError);
 	}
 	
 	public List<String> getGlobalErrorMessage(){
 		return getGlobalErrorMessage();
 	}
 	
 	public List<FieldErrorOutputDto> getError(){
 		return this.fieldErros;
 	}
 	
 	public int GetNumberOfErrors(){
 		return this.globalErrorMessages.size() + this.fieldErros.size();
 	}

}
