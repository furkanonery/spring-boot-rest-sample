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

import com.example.questapp.entities.Like;
import com.example.questapp.requests.LikeCreateRequest;
import com.example.questapp.services.LikesService;

@RestController
@RequestMapping("/likes")
public class LikesController {

	private LikesService likesService;

	public LikesController(LikesService likesService) {

		this.likesService = likesService;
	}

	@GetMapping
	public List<Like> getAllComments(@RequestParam Optional<Long> user_id, @RequestParam Optional<Long> post_id) {
		return likesService.getAllLikes(user_id, post_id);
	}
	
	@GetMapping("/{likeID}")
	public Like getOneLike(@PathVariable Long likeID) {
		return likesService.getOneLike(likeID);
	}
	
	@PostMapping
	public Like createOneLike(@RequestBody LikeCreateRequest lBody) {
		
		return likesService.createOneLike(lBody);
	}
	
	/*@PutMapping("/{commentID}")
	public Like updateOneLike(@PathVariable Long commentID, @RequestBody Like lBody) {
		return likesService.updateOneLike(commentID, lBody);
	}*/
	
	@DeleteMapping("/{likeID}")
	public void deleteOneComment(@PathVariable Long likeID) {
		likesService.deleteOneLike(likeID);
	}
	

}
