package br.com.alura.forum.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.input.TopicSearchInputDto;
import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.topic_domain.Topic;

@RestController
@RequestMapping("/api")
public class TopicController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@GetMapping(value="/topics",produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<TopicBriefOutputDto> listTopics(TopicSearchInputDto topicSearch, @PageableDefault(sort="creationInstant",direction=Sort.Direction.DESC) Pageable pageRequest){
		
 		Specification<Topic> topicSearchSpecification = topicSearch.build();
 		
		Page<Topic> topics = topicRepository.findAll(topicSearchSpecification,pageRequest);
		
		
		return TopicBriefOutputDto.listFromTopicsPage(topics);
	}
	
	

}
