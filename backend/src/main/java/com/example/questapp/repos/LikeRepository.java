package com.example.questapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questapp.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

	List<Like> findByPostIdAndUserId(Long user_id, Long post_id);
	List<Like> findByUserId(Long user_id);
	List<Like> findByPostId(Long post_id);
}
