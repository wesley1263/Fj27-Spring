package br.com.alura.forum.controller.dto.output;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.alura.forum.model.topic_domain.Topic;
import br.com.alura.forum.model.topic_domain.TopicStatus;

public class TopicBriefOutputDto {

	private Long id;
	private String shortDescription;
	private long secondsSinceLastUpdate;
	private String ownerName;
	private String courseName;
	private String subcategoryName;
	private String categoryName;
	private int numberOfResponse;
	private boolean solved;
	
	
	public TopicBriefOutputDto(){
		
	}
	
	public TopicBriefOutputDto(Topic topic) {
		this.id = topic.getId();
		this.shortDescription = topic.getShortDescription();
		this.secondsSinceLastUpdate = getSecundsSince(topic.getLastUpdate());
		this.ownerName = topic.getOwnerName();
		this.courseName = topic.getCourse().getName();
		this.subcategoryName = topic.getCourse().getSubcategoryName();
		this.categoryName = topic.getCourse().getCategoryName();
		this.numberOfResponse = topic.getNumberOfAnswers();
		this.solved = TopicStatus.SOLVED.equals(topic.getStatus());
	
	}


	private long getSecundsSince(Instant lastUpdate) {
		return Duration.between(lastUpdate, Instant.now()).get(ChronoUnit.SECONDS);
	}
	
	
	public static List<TopicBriefOutputDto> listFromTopics(List<Topic> topics){
		return topics.stream().map(TopicBriefOutputDto::new).collect(Collectors.toList());
	}
	
	
	public static Page<TopicBriefOutputDto> listFromTopicsPage(Page<Topic> topicPage){
		return topicPage.map(TopicBriefOutputDto::new);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public long getSecondsSinceLastUpdate() {
		return secondsSinceLastUpdate;
	}

	public void setSecondsSinceLastUpdate(long secondsSinceLastUpdate) {
		this.secondsSinceLastUpdate = secondsSinceLastUpdate;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getNumberOfResponse() {
		return numberOfResponse;
	}

	public void setNumberOfResponse(int numberOfResponse) {
		this.numberOfResponse = numberOfResponse;
	}

	public boolean isSolved() {
		return solved;
	}

	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	
	
	
}
