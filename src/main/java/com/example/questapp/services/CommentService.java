package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questapp.entities.Comment;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.repos.CommentRepository;
import com.example.questapp.requests.CommentCreateRequest;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	private CommentService(UserService userService, PostService postService, CommentRepository commentRepository) {
		this.userService = userService;
		this.postService = postService;
		this.commentRepository = commentRepository;
	}

	public List<Comment> getAllComments(Optional<Long> user_id, Optional<Long> post_id) {
		// TODO Auto-generated method stub
		if(user_id.isPresent() && post_id.isPresent()) {
			return commentRepository.findByPostIdAndUserId(user_id.get(),post_id.get());
		}
		else if(user_id.isPresent()) {
			return commentRepository.findByUserId(user_id.get());
		}
		else if(post_id.isPresent()) {
			return commentRepository.findByPostId(post_id.get());
		}
		else
			return commentRepository.findAll();
	}

	public Comment getOneComment(Long commentID) {
		// TODO Auto-generated method stub
		return commentRepository.findById(commentID).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest cBody) {
		// TODO Auto-generated method stub
		User user = userService.getOneUserById(cBody.getUserID());
		Post post = postService.getOnePostById(cBody.getPostID());
		if(user == null || post == null)
			return null;
		else {
			Comment saveComment = new Comment();
			saveComment.setPost(post);
			saveComment.setUser(user);
			saveComment.setText(cBody.getText());
			return commentRepository.save(saveComment);
		}
	}

	public Comment updateOneComment(Long commentID, Comment cBody) {
		
		Optional<Comment> comment = commentRepository.findById(commentID);
		if (comment.isPresent()) {
			Comment foundComment = comment.get();
			foundComment.setText(cBody.getText());
			commentRepository.save(foundComment);
			return foundComment;
		} else
			return null;
	}

	public void deleteOneComment(Long commentID) {
		
		Optional<Comment> comment = commentRepository.findById(commentID);
		if (comment.isPresent())
			commentRepository.deleteById(commentID);
	
	}
	
	
}
