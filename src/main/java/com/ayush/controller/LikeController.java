package com.ayush.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.dto.LikeDto;
import com.ayush.exception.TwitException;
import com.ayush.exception.UserException;
import com.ayush.mapper.LikeDtoMapper;
import com.ayush.model.Like;
import com.ayush.model.User;
import com.ayush.service.LikeService;
import com.ayush.service.UserService;

@RestController
@RequestMapping("/api")
public class LikeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/{twitId}/likes")
	public ResponseEntity<LikeDto> likeTwit(@PathVariable Long twitId,
			@RequestHeader("Authorization") String jwt) throws UserException, TwitException{
		
		User user = userService.findUserProfileByJwt(jwt);
		Like like = likeService.likeTwit(twitId, user);
		
		LikeDto likeDto = LikeDtoMapper.toLikeDto(like, user);
		
		
		
		return new ResponseEntity<LikeDto>(likeDto, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/twit/{twitId}/")
	public ResponseEntity<List<LikeDto>> getAllLikes(@PathVariable Long twitId,
			@RequestHeader("Authorization") String jwt) throws UserException, TwitException{
		
		User user = userService.findUserProfileByJwt(jwt);
		List<Like> like = likeService.getAllLikes(twitId);
		
		List<LikeDto> likeDtos = LikeDtoMapper.toLikeDtos(like, user);
		return new ResponseEntity<>(likeDtos, HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	{
		
		
	}
	
	
}
