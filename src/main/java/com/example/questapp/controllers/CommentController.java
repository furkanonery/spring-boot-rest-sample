package com.example.questapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questapp.entities.Comment;
import com.example.questapp.requests.CommentCreateRequest;
import com.example.questapp.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {

		this.commentService = commentService;
	}

	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> user_id, @RequestParam Optional<Long> post_id) {
		return commentService.getAllComments(user_id, post_id);
	}
	
	@GetMapping("/{commentID}")
	public Comment getOneComment(@PathVariable Long commentID) {
		return commentService.getOneComment(commentID);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest cBody) {
		
		return commentService.createOneComment(cBody);
	}
	
	@PutMapping("/{commentID}")
	public Comment updateOneComment(@PathVariable Long commentID, @RequestBody Comment cBody) {
		return commentService.updateOneComment(commentID, cBody);
	}
	
	@DeleteMapping("/{commentID}")
	public void deleteOneComment(@PathVariable Long commentID) {
		commentService.deleteOneComment(commentID);
	}
	

}
