package br.com.alura.forum.controller.dto.output;
import java.util.List;

import br.com.alura.forum.model.Category;

public class DashboardBriefOutputDto {
	
	private String categoryName;
	private List<String> subcategories;
	private int allTopics;
	private int lastWeekTopics;
	private int unansweredTopics;
	
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<String> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<String> subcategories) {
		this.subcategories = subcategories;
	}
	public int getAllTopics() {
		return allTopics;
	}
	public void setAllTopics(int allTopics) {
		this.allTopics = allTopics;
	}
	public int getLastWeekTopics() {
		return lastWeekTopics;
	}
	public void setLastWeekTopics(int lastWeekTopics) {
		this.lastWeekTopics = lastWeekTopics;
	}
	public int getUnansweredTopics() {
		return unansweredTopics;
	}
	public void setUnansweredTopics(int unansweredTopics) {
		this.unansweredTopics = unansweredTopics;
	}
	
	public DashboardBriefOutputDto(Category category){
		this.categoryName = category.getName();
		this.subcategories = category.getSubcategoryNames();
	}
	

}
