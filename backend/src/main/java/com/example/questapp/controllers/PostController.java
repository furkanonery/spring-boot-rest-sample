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

import com.example.questapp.entities.Post;
import com.example.questapp.requests.PostCreateRequest;
import com.example.questapp.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@GetMapping
	public List<Post> getAllPosts(@RequestParam Optional<Long> user_id) {
		return postService.getAllPosts(user_id);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}
	
	@GetMapping("/{post_id}")
	public Post getOnePost(@PathVariable Long post_id) {
		// custom expection
		return postService.getOnePostById(post_id);
	}
	
	@PutMapping("/{post_id}")
	public Post updateOnePost(@PathVariable Long post_id, @RequestBody Post postBody) {
		return postService.updateOnePostById(post_id, postBody);
	}
	
	@DeleteMapping("/{post_id}")
	public void updateOnePost(@PathVariable Long post_id) {
		postService.deleteOnePostById(post_id);
	}
	
	
	
}
