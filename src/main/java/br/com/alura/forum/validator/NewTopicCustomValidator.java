package br.com.alura.forum.validator;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.PossibleSpam;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic_domain.Topic;

public class NewTopicCustomValidator implements Validator {
	
	private final TopicRepository topicRepository;
	private  User userLogged;
	
	
	

	public NewTopicCustomValidator(TopicRepository topicRepository, User userLogged) {
		this.topicRepository = topicRepository;
		this.userLogged = userLogged;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Instant oneHourArgo = Instant.now().minus(1,ChronoUnit.HOURS);
		List<Topic> topics = topicRepository.findByOwnerAndCreationInstantAfterOrderByCreationInstantAsc(userLogged, oneHourArgo);
	
		PossibleSpam possibleSpam = new PossibleSpam(topics);
		if(possibleSpam.hasTopicLimitExceeded()){
			long minutesToNextTopic = possibleSpam.minutesNextTopics(oneHourArgo);
			errors.reject("newTopicInputDto.limit.exceeded",new Object[]{minutesToNextTopic},"O limite individual de novo tópicos por hora foi excedido!");
		}
	}

	

}
