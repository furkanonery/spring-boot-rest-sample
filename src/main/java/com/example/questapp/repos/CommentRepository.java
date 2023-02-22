package com.example.questapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questapp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByPostIdAndUserId(Long user_id, Long post_id);
	List<Comment> findByUserId(Long user_id);
	List<Comment> findByPostId(Long post_id);
}
