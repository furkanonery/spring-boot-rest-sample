package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.repos.PostRepository;
import com.example.questapp.requests.PostCreateRequest;

@Service
public class PostService {
	
	private PostRepository postRepository;
	private UserService userService;

	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<Post> getAllPosts(Optional<Long> user_id) {
		// TODO Auto-generated method stub
		if(user_id.isPresent()) {
			return postRepository.findByUserId(user_id);
		}
		return postRepository.findAll();
	}

	public Post getOnePostById(Long post_id) {
		// TODO Auto-generated method stub
		return postRepository.findById(post_id).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		// TODO Auto-generated method stub
		User user = userService.getOneUserById(newPostRequest.getUserID());
		if(user == null)
			return null;
		Post toSave = new Post();
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		return postRepository.save(toSave);
	}

	public Post updateOnePostById(Long post_id, Post updatePost) {
		// TODO Auto-generated method stub
		Optional<Post> post = postRepository.findById(post_id);
		if (post.isPresent()) {
			Post foundPost = post.get();
			foundPost.setText(updatePost.getText());
			foundPost.setTitle(updatePost.getTitle());
			postRepository.save(foundPost);
			return foundPost;
		} else
			return null;
	}

	public void deleteOnePostById(Long post_id) {
		// TODO Auto-generated method stub
		Optional<Post> post = postRepository.findById(post_id);
		if (post.isPresent())
			postRepository.deleteById(post_id);
	}
}
