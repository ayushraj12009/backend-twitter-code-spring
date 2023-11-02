package com.ayush.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayush.model.Twit;
import com.ayush.model.User;

public interface TwitRepository extends JpaRepository<Twit, Long>{
	
	List<Twit> findAllByisTwitTrueOrderByCreatedAtDesc();
	
	List<Twit> findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(User user, Long userId);
	
	List<Twit> findByLikesContainingOrderByCreatedAtDesc(User user);
	
	@Query("SELECT t FROM Twit t JOIN t.likes l WHERE l.user.id = :userId")
	List<Twit> findByLikesUser_id(@Param("userId") Long userId);


	
	
	
	
	
	
	
	
	

}
