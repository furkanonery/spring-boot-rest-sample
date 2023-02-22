package com.example.questapp.requests;

import lombok.Data;

@Data
public class CommentCreateRequest {
	
	String text;
	Long userID;
	Long postID;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public Long getPostID() {
		return postID;
	}
	public void setPostID(Long postID) {
		this.postID = postID;
	}
	
	
}
