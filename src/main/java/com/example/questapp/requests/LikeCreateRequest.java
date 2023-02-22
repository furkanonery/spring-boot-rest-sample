package com.example.questapp.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
	
	Long userID;
	Long postID;
	
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
