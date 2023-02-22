package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questapp.entities.Comment;
import com.example.questapp.entities.Like;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.repos.CommentRepository;
import com.example.questapp.repos.LikeRepository;
import com.example.questapp.requests.CommentCreateRequest;
import com.example.questapp.requests.LikeCreateRequest;

@Service
public class LikesService {

    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    private LikesService(UserService userService, PostService postService, LikeRepository likeRepository) {
        this.userService = userService;
        this.postService = postService;
        this.likeRepository = likeRepository;
    }

    public List<Like> getAllLikes(Optional<Long> user_id, Optional<Long> post_id) {
        // TODO Auto-generated method stub
        if (user_id.isPresent() && post_id.isPresent()) {
            return likeRepository.findByPostIdAndUserId(user_id.get(), post_id.get());
        } else if (user_id.isPresent()) {
            return likeRepository.findByUserId(user_id.get());
        } else if (post_id.isPresent()) {
            return likeRepository.findByPostId(post_id.get());
        } else
            return likeRepository.findAll();
    }

    public Like getOneLike(Long likeID) {
        // TODO Auto-generated method stub
        return likeRepository.findById(likeID).orElse(null);
    }

    public Like createOneLike(LikeCreateRequest lBody) {
        // TODO Auto-generated method stub
        User user = userService.getOneUserById(lBody.getUserID());
        Post post = postService.getOnePostById(lBody.getPostID());
        if (user == null || post == null)
            return null;
        else {
            Like saveLike = new Like();
            saveLike.setPost(post);
            saveLike.setUser(user);
            return likeRepository.save(saveLike);
        }
    }

	/*public Like updateOneLike(Long likeID, Like lBody) {

		Optional<Like> like = likeRepository.findById(likeID);
		if (like.isPresent()) {
			Like foundLike = like.get();
			foundLike.setText(lBody.getText());
			commentRepository.save(foundComment);
			return foundComment;
		} else
			return null;
	}*/

    public void deleteOneLike(Long likeID) {

        Optional<Like> like = likeRepository.findById(likeID);
        if (like.isPresent())
            likeRepository.deleteById(likeID);

    }


}
