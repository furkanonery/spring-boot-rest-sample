package com.example.questapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {
	
	String text;
	String title;
	Long userID;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
}
