package br.com.alura.forum.controller.dto.output;

import java.time.Instant;

import br.com.alura.forum.model.topic_domain.Topic;
import br.com.alura.forum.model.topic_domain.TopicStatus;

public class TopicOutputDto {
	
	private Long id;
	private String shortDescription;
	private String content;
	private TopicStatus status;
	private int numberOfResponse;
	private Instant createInstat;
	private Instant lastUpdate;
	
	private String ownerName;
	private String courseName;
	private String subcategoryName;
	private String categoryName;

	public TopicOutputDto(Topic topic) {
		this.id = topic.getId();
		this.shortDescription = topic.getShortDescription();
		this.content = topic.getContent();
		this.status = topic.getStatus();
		this.numberOfResponse = topic.getNumberOfAnswers();
		this.createInstat = topic.getCreationInstant();
		this.lastUpdate = topic.getLastUpdate();
		this.ownerName = topic.getOwner().getName();
		this.courseName = topic.getCourse().getName();
		this.subcategoryName = topic.getCourse().getCategoryName();
		this.categoryName = topic.getCourse().getCategoryName();
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public void setStatus(TopicStatus status) {
		this.status = status;
	}

	public int getNumberOfResponse() {
		return numberOfResponse;
	}

	public void setNumberOfResponse(int numberOfResponse) {
		this.numberOfResponse = numberOfResponse;
	}

	public Instant getCreateInstat() {
		return createInstat;
	}

	public void setCreateInstat(Instant createInstat) {
		this.createInstat = createInstat;
	}

	public Instant getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
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

	
	
	

}
