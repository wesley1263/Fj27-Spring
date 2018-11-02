package br.com.alura.forum.controller;


import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.input.NewTopicInputDto;
import br.com.alura.forum.controller.dto.input.TopicSearchInputDto;
import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.controller.dto.output.TopicOutputDto;
import br.com.alura.forum.controller.repository.CourseRepository;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic_domain.Topic;
import br.com.alura.forum.validator.NewTopicCustomValidator;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
	
	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<TopicBriefOutputDto> listTopics(TopicSearchInputDto topicSearch, @PageableDefault(sort="creationInstant",direction=Sort.Direction.DESC) Pageable pageRequest){
		
 		Specification<Topic> topicSearchSpecification = topicSearch.build();
 		
		Page<Topic> topics = topicRepository.findAll(topicSearchSpecification,pageRequest);
		
		
		return TopicBriefOutputDto.listFromTopicsPage(topics);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createTopic(@RequestBody @Valid NewTopicInputDto newTopicInputDto, @AuthenticationPrincipal User loggedUser, UriComponentsBuilder uriBuilder){
		
		Topic topic = newTopicInputDto.build(loggedUser, courseRepository);
		
		this.topicRepository.save(topic);
		
		URI path = uriBuilder.path("/api/topics/{id}").buildAndExpand(topic.getId()).toUri();
		
		return ResponseEntity.created(path).body(new TopicOutputDto(topic));
	}
	
	@InitBinder("NewTopicInputDto")
	public void initBinder(WebDataBinder binder, @AuthenticationPrincipal User userLogged){
		binder.addValidators(new NewTopicCustomValidator(topicRepository, userLogged));
	}

}
